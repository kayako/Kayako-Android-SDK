package com.kayako.sdk.android.k5.common.adapter.messengerlist.helper;

import com.kayako.sdk.android.k5.common.adapter.BaseIdentityListItem;
import com.kayako.sdk.android.k5.common.adapter.BaseListItem;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

@RunWith(MockitoJUnitRunner.class)
public class DiffUtilsHelperTest {

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Mock
    private BaseListItem baseListItem;

    @Mock
    private BaseIdentityListItem baseIdentityListItem;

    @Ignore
    @Test
    public void whenBothItemTypeNotSameThenFalse() {
        when(baseListItem.getItemType()).thenReturn(1,2);
        errorCollector.checkThat(DiffUtilsHelper.areItemsSame(baseListItem, baseListItem), is(false));

    }

    @Test
    public void whenOfBaseIdentityListItemAndSameIdThenTrue() {
        when(baseIdentityListItem.getId()).thenReturn(1L, 1L);
        errorCollector.checkThat(DiffUtilsHelper.areItemsSame(baseIdentityListItem, baseIdentityListItem), is(true));
    }

    @Test
    public void whenContentsSameThenTrue() {
        Map<String, String > map = new HashMap<>();
        map.put("key", "value");
        when(baseListItem.getContents()).thenReturn(map);
        errorCollector.checkThat(DiffUtilsHelper.areItemsSame(baseListItem, baseListItem), is(true));
    }

    @Test
    public void whenItemTypesAreSameThenFalse() {
        errorCollector.checkThat(DiffUtilsHelper.areItemsSame(baseListItem, baseListItem), is(false));
    }

    @Test
    public void areContentsSame() {
        Map<String, String > map = new HashMap<>();
        map.put("key", "value");
        when(baseListItem.getContents()).thenReturn(map);
        errorCollector.checkThat(DiffUtilsHelper.areContentsSame(baseListItem, baseListItem), is(true));
    }

    @Test
    public void whenNullObjectPassedInConvertToStringThenReturnNull() {
        errorCollector.checkThat(DiffUtilsHelper.convertToString(null), nullValue());
    }

    @Test
    public void convertToStringWithValidParams() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        StringBuffer bf = new StringBuffer();
        bf.append("1").append("=").append("1").append("\n")
                .append("2").append("=").append("2").append("\n")
                .append("3").append("=").append("3").append("\n");
        errorCollector.checkThat(DiffUtilsHelper.convertToString(map), is(equalTo(bf.toString())));
    }
}
