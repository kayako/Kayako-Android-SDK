package com.kayako.sdk.android.k5.common.adapter.messengerlist.view;

import com.kayako.sdk.android.k5.common.adapter.messengerlist.Attachment;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.DeliveryIndicator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;

public class AttachmentMessageContinuedSelfListItemTest {

    private final Map<String, String> data = new HashMap<>();
    private long time;
    private boolean fadeBackground;
    private long id;
    private Attachment attachment;
    private DeliveryIndicator deliveryIndicator;
    private AttachmentMessageContinuedSelfListItem listItem;

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Before
    public void setUp() {
        id = 1L;
        time = 1_000L;
        attachment = new Attachment(Attachment.TYPE.URL);
        deliveryIndicator = new DeliveryIndicator(1, 1, time);
        fadeBackground = false;
        listItem = new AttachmentMessageContinuedSelfListItem(
                id, attachment, time, deliveryIndicator, fadeBackground, (Map)data);
    }

    @Test
    public void whenValidParamsConstructorThenObjectCreated() {
        errorCollector.checkThat(listItem.getId(), is(id));
        errorCollector.checkThat(listItem.getAttachment(), is(attachment));
        errorCollector.checkThat(listItem.getTime(), is(time));
        errorCollector.checkThat(listItem.getDeliveryIndicator(), is(deliveryIndicator));
        errorCollector.checkThat(listItem.isFadeBackground(), is(fadeBackground));
        errorCollector.checkThat((Map)listItem.getData(), is(data));
    }

    @Test
    public void setAttachment() {
        //Arrange
        final Attachment attachmentLocal = new Attachment(Attachment.TYPE.FILE);

        //Act
        listItem.setAttachment(attachmentLocal);

        //Assert
        errorCollector.checkThat(listItem.getAttachment(), is(attachmentLocal));
        errorCollector.checkThat(listItem.getAttachment().getType(), is(Attachment.TYPE.FILE));
    }

    @Test
    public void getContents() {
        errorCollector.checkThat(listItem.getContents().size(), is(6));
        errorCollector.checkThat(listItem.getContents().get("fadeBackground"), is(String.valueOf(fadeBackground)));
    }
}
