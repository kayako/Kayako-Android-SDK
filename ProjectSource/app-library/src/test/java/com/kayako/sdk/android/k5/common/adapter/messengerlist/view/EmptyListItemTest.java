package com.kayako.sdk.android.k5.common.adapter.messengerlist.view;

import com.kayako.sdk.android.k5.common.adapter.messengerlist.MessengerListType;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class EmptyListItemTest {

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void whenValidParamsConstructorThenObjectCreated() {
        EmptyListItem emptyListItem = new EmptyListItem();
        errorCollector.checkThat(emptyListItem, notNullValue());
        errorCollector.checkThat(emptyListItem.getItemType(), is(MessengerListType.EMPTY_SEPARATOR));
    }

    @Test
    public void getContents(){
        Map map = new EmptyListItem().getContents();
        errorCollector.checkThat(map, notNullValue());
        errorCollector.checkThat(map.size() == 0, is(true));
    }
}
