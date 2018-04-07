package com.kayako.sdk.android.k5.common.adapter.messengerlist;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

public class ViewBehaviourTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void test_constructor() {
        Boolean showTime = true;
        Boolean showAvatar = true;
        Boolean showChannel = true;
        Boolean showAsSelf = false;
        Boolean showDeliveryIndicator = false;
        ViewBehaviour viewBehaviour = new ViewBehaviour(
                showTime, showAvatar, showChannel, showAsSelf, showDeliveryIndicator, ViewBehaviour.MessageType.ATTACHMENT);

        errorCollector.checkThat(viewBehaviour, notNullValue());
        errorCollector.checkThat(viewBehaviour.showTime, is(true));
        errorCollector.checkThat(viewBehaviour.showAsSelf, is(false));
        errorCollector.checkThat(viewBehaviour.messageType, is(not(ViewBehaviour.MessageType.SIMPLE)));
        errorCollector.checkThat(viewBehaviour.messageType, is(equalTo(ViewBehaviour.MessageType.ATTACHMENT)));
    }
}
