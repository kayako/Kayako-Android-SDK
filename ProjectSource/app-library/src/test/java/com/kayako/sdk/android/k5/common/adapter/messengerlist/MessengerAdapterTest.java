package com.kayako.sdk.android.k5.common.adapter.messengerlist;

import android.support.v7.widget.RecyclerView;
import android.test.mock.MockContext;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kayako.sdk.android.k5.R;
import com.kayako.sdk.android.k5.common.adapter.BaseListItem;
import com.kayako.sdk.android.k5.common.adapter.list.ListType;
import com.kayako.sdk.android.k5.common.adapter.loadmorelist.EndlessRecyclerViewScrollAdapter;
import com.kayako.sdk.android.k5.common.adapter.loadmorelist.LoadingViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.AttachmentHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.DeliveryIndicatorHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.InputFieldEmailHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.InputFieldFeedbackCommentHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.InputFieldFeedbackCompletedHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.InputFieldFeedbackRatingHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.MessageStyleHelper;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageContinuedOtherListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageContinuedOtherViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageContinuedSelfListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageContinuedSelfViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageOtherListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageOtherViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageSelfListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.AttachmentMessageSelfViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.BotMessageListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.BotMessageViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.DateSeparatorListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.DateSeparatorViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.EmptyViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputEmailListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputEmailViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedback;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedbackCommentListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedbackCommentViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedbackCompletedListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedbackCompletedViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedbackRatingListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFeedbackRatingViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.InputFieldViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageContinuedOtherListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageContinuedOtherViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageContinuedSelfListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageContinuedSelfViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageOtherListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageOtherViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageSelfListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SimpleMessageSelfViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SystemMessageListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.SystemMessageViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.TypingListItem;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.TypingViewHolder;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.view.UnreadSeparatorViewHolder;
import com.kayako.sdk.android.k5.common.utils.DateTimeUtils;
import com.kayako.sdk.android.k5.common.utils.ImageUtils;
import com.kayako.sdk.android.k5.common.view.CircleImageView;
import com.kayako.sdk.android.k5.core.Kayako;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.mockito.Mockito.verify;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LayoutInflater.class,
        DeliveryIndicatorHelper.class,
        RecyclerView.ViewHolder.class,
        MessageStyleHelper.class,
        Kayako.class,
        ImageUtils.class,
        AttachmentHelper.class,
        DateTimeUtils.class,
        Html.class,
        InputFieldEmailHelper.class,
        InputFieldFeedbackRatingHelper.class,
        InputFieldFeedbackCommentHelper.class,
        InputFieldFeedbackCompletedHelper.class})
public class MessengerAdapterTest {

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Mock
    private MessengerAdapter.OnItemClickListener mItemClickListener;

    @Mock
    private MessengerAdapter.OnAvatarClickListener mAvatarClickListener;

    @Mock
    private MessengerAdapter.OnAttachmentClickListener mAttachmentClickListener;

    @Mock
    private View mockView;

    @Mock
    private LayoutInflater mockInflater;

    @Mock
    private ViewGroup mockParent;

    @Mock
    private LinearLayout linearLayout;

    @Mock
    private Map<String, Object> data;

    private MockContext mockContext;

    @Mock
    private List<BaseListItem> baseListItemList;

    @Mock
    private CircleImageView channel;

    @Mock
    private TextView timeTextView;

    @Mock
    private InputFieldViewHolder inputFieldViewHolder;

    @Mock
    private EndlessRecyclerViewScrollAdapter recyclerViewScrollAdapter;

    @InjectMocks
    private MessengerAdapter messengerAdapter;

    private static final int POSITION = 0;
    private static final long NON_ZERO_TIME = System.currentTimeMillis();
    private static final long ZERO_TIME = 0L;
    private static final long ID = 1L;

    @Before
    public void setUp() {
        mockStatic(LayoutInflater.class);
        mockStatic(RecyclerView.ViewHolder.class);
        mockContext = new MockContext();
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeSimpleMessageSelf() {
        final SimpleMessageSelfListItem listItem = mock(SimpleMessageSelfListItem.class);
        mockStatic(DeliveryIndicatorHelper.class);
        mockStatic(MessageStyleHelper.class);
        SimpleMessageSelfViewHolder viewHolder = mock(SimpleMessageSelfViewHolder.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.SIMPLE_MESSAGE_SELF);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(DeliveryIndicatorHelper.class);
        DeliveryIndicatorHelper.setDeliveryIndicatorView(listItem.getDeliveryIndicator(), listItem.getTime(), viewHolder);

        verifyStatic(MessageStyleHelper.class);
        MessageStyleHelper.setMessage(viewHolder.message, listItem.getMessage());
        MessageStyleHelper.setMessageStyle(true, listItem.isFadeBackground(), viewHolder.message, listItem.getMessage());
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageOther() {
        AttachmentMessageOtherListItem listItem = new AttachmentMessageOtherListItem
                (ID, "", null, mock(Attachment.class), ZERO_TIME, data);
        AttachmentMessageOtherViewHolder viewHolder = mock(AttachmentMessageOtherViewHolder.class);
        viewHolder.channel = channel;
        viewHolder.time = timeTextView;

        mockStatic(AttachmentHelper.class);
        mockStatic(ImageUtils.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.ATTACHMENT_MESSAGE_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(channel, times(1)).setVisibility(View.GONE);
        verify(timeTextView, times(1)).setVisibility(View.GONE);

        verifyStatic(ImageUtils.class);
        ImageUtils.setAvatarImage(Kayako.getApplicationContext(),
                viewHolder.avatar, listItem.getAvatarUrl());

        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(),
                viewHolder.attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageOtherElse() {
        AttachmentMessageOtherListItem listItem = new AttachmentMessageOtherListItem(ID, "",
                mock(ChannelDecoration.class), mock(Attachment.class), NON_ZERO_TIME, data);
        AttachmentMessageOtherViewHolder viewHolder = mock(AttachmentMessageOtherViewHolder.class);
        viewHolder.channel = channel;
        viewHolder.time = timeTextView;

        mockStatic(AttachmentHelper.class);
        mockStatic(ImageUtils.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.ATTACHMENT_MESSAGE_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(channel, times(1)).setVisibility(View.VISIBLE);
        verify(timeTextView, times(1)).setVisibility(View.VISIBLE);

        verifyStatic(ImageUtils.class);
        ImageUtils.setAvatarImage(Kayako.getApplicationContext(),
                viewHolder.avatar, listItem.getAvatarUrl());

        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(),
                viewHolder.attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);

    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsDateSeperator() {
        DateSeparatorListItem listItem = new DateSeparatorListItem(NON_ZERO_TIME);
        DateSeparatorViewHolder viewHolder = mock(DateSeparatorViewHolder.class);
        viewHolder.time = timeTextView;

        mockStatic(Kayako.class);
        mockStatic(DateTimeUtils.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.DATE_SEPARATOR);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(timeTextView, times(1)).setText(DateTimeUtils.
                formatDate(Kayako.getApplicationContext(), listItem.getTimeInMilliseconds()));
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsEmptySeperator() {
        RecyclerView.ViewHolder viewHolder = mock(RecyclerView.ViewHolder.class);
        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.EMPTY_SEPARATOR);
        messengerAdapter.onBindViewHolder(viewHolder, POSITION);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsSystemMessage() {
        SystemMessageListItem listItem = mock(SystemMessageListItem.class);
        SystemMessageViewHolder viewHolder = mock(SystemMessageViewHolder.class);
        viewHolder.message = timeTextView;

        mockStatic(Html.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.SYSTEM_MESSAGE);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        messengerAdapter.onBindViewHolder(viewHolder, POSITION);
        verify(timeTextView).setText(Html.fromHtml(listItem.getMessage()));
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsInputEmail() {
        InputEmailListItem listItem = mock(InputEmailListItem.class);
        InputEmailViewHolder viewHolder = mock(InputEmailViewHolder.class);

        mockStatic(InputFieldEmailHelper.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.INPUT_FIELD_EMAIL);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(InputFieldEmailHelper.class);
        InputFieldEmailHelper.configureInputEmailField(viewHolder, listItem);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsInputFieldFeedback() {
        InputFeedbackRatingListItem listItem = mock(InputFeedbackRatingListItem.class);
        InputFeedbackRatingViewHolder viewHolder = mock(InputFeedbackRatingViewHolder.class);

        mockStatic(InputFieldFeedbackRatingHelper.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.INPUT_FIELD_FEEDBACK_RATING);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(InputFieldEmailHelper.class);
        InputFieldFeedbackRatingHelper.configureInputFeedbackField(viewHolder, listItem);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsInputFieldFeedbackComment() {
        InputFeedbackCommentListItem listItem = mock(InputFeedbackCommentListItem.class);
        InputFeedbackCommentViewHolder viewHolder = mock(InputFeedbackCommentViewHolder.class);

        mockStatic(InputFieldFeedbackCommentHelper.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.
                INPUT_FIELD_FEEDBACK_COMMENT);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(InputFieldFeedbackCommentHelper.class);
        InputFieldFeedbackCommentHelper.configureInputFeedbackField(viewHolder, listItem);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsInputFieldFeedbackCompleted() {
        InputFeedbackCompletedListItem listItem = new InputFeedbackCompletedListItem(
                "instructionMessage", InputFeedback.RATING.GOOD, "feedback");
        InputFeedbackCompletedViewHolder viewHolder = mock(InputFeedbackCompletedViewHolder.class);

        mockStatic(InputFieldFeedbackCompletedHelper.class);
        mockStatic(Html.class);

        when(viewHolder.getItemViewType()).thenReturn(
                MessengerListType.INPUT_FIELD_FEEDBACK_COMPLETED);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(InputFieldFeedbackCompletedHelper.class);
        InputFieldFeedbackCompletedHelper.configureInputFeedbackCompletedField(viewHolder, listItem);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsInputFieldTypingFooter() {
        TypingListItem listItem = mock(TypingListItem.class);
        TypingViewHolder viewHolder = mock(TypingViewHolder.class);

        mockStatic(ImageUtils.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.TYPING_FOOTER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(ImageUtils.class);
        ImageUtils.setAvatarImage(Kayako.getApplicationContext(), viewHolder.avatar,
                listItem.getAvatarUrl());
        ImageUtils.setImage(Kayako.getApplicationContext(), viewHolder.animatedTypingImage,
                null, R.drawable.ko__img_loading_dots);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsDefault() {
        RecyclerView.ViewHolder viewHolder = mock(RecyclerView.ViewHolder.class);
        when(viewHolder.getItemViewType()).thenReturn(99999); ///default
        messengerAdapter.onBindViewHolder(viewHolder, POSITION);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsBotMessageOtherElse() {
        BotMessageListItem listItem = new BotMessageListItem("", ZERO_TIME);
        BotMessageViewHolder viewHolder = mock(BotMessageViewHolder.class);
        viewHolder.time = timeTextView;
        viewHolder.message = timeTextView;
        mockStatic(Html.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.BOT_MESSAGE);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(timeTextView).setText(Html.fromHtml(listItem.getMessage()));
        verify(timeTextView, times(1)).setVisibility(View.GONE);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsBotMessageOtherElseCase() {
        BotMessageListItem listItem = new BotMessageListItem("", NON_ZERO_TIME);
        BotMessageViewHolder viewHolder = mock(BotMessageViewHolder.class);
        viewHolder.time = timeTextView;
        viewHolder.message = timeTextView;
        mockStatic(Html.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.BOT_MESSAGE);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(timeTextView).setText(Html.fromHtml(listItem.getMessage()));
        verify(timeTextView, times(1)).setVisibility(View.VISIBLE);
    }


    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageContinuedOther() {
        ChannelDecoration channelDecoration = null;
        AttachmentMessageContinuedOtherListItem listItem = new AttachmentMessageContinuedOtherListItem
                (ID, mock(Attachment.class), ZERO_TIME, data);
        AttachmentMessageContinuedOtherViewHolder viewHolder =
                mock(AttachmentMessageContinuedOtherViewHolder.class);
        viewHolder.time = timeTextView;

        mockStatic(AttachmentHelper.class);

        when(viewHolder.getItemViewType()).thenReturn(
                MessengerListType.ATTACHMENT_MESSAGE_CONTINUED_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(timeTextView, times(1)).setVisibility(View.GONE);
        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(), viewHolder.
                attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageContinuedOtherElseCase() {
        ChannelDecoration channelDecoration = null;
        AttachmentMessageContinuedOtherListItem listItem = new AttachmentMessageContinuedOtherListItem
                (ID, mock(Attachment.class), NON_ZERO_TIME, data);
        AttachmentMessageContinuedOtherViewHolder viewHolder =
                mock(AttachmentMessageContinuedOtherViewHolder.class);
        viewHolder.time = timeTextView;

        mockStatic(AttachmentHelper.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.
                ATTACHMENT_MESSAGE_CONTINUED_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);
        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(timeTextView, times(1)).setVisibility(View.VISIBLE);
        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(),
                viewHolder.attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageOtherElseCase() {
        AttachmentMessageOtherListItem listItem = new AttachmentMessageOtherListItem
                (ID, "", null, mock(Attachment.class), NON_ZERO_TIME, data);
        AttachmentMessageOtherViewHolder viewHolder = mock(AttachmentMessageOtherViewHolder.class);
        viewHolder.channel = channel;
        viewHolder.time = timeTextView;

        mockStatic(AttachmentHelper.class);
        mockStatic(ImageUtils.class);
        mockStatic(Kayako.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.ATTACHMENT_MESSAGE_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(timeTextView, times(1)).setVisibility(View.VISIBLE);

        verifyStatic(ImageUtils.class);
        ImageUtils.setAvatarImage(Kayako.getApplicationContext(), viewHolder.avatar,
                listItem.getAvatarUrl());

        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(),
                viewHolder.attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);

    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageSelf() {
        AttachmentMessageSelfListItem listItem = new AttachmentMessageSelfListItem
                (ID, mock(DeliveryIndicator.class), false, mock(Attachment.class),
                        NON_ZERO_TIME, data);

        mockStatic(AttachmentHelper.class);
        mockStatic(DeliveryIndicatorHelper.class);
        AttachmentMessageSelfViewHolder viewHolder = mock(AttachmentMessageSelfViewHolder.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.ATTACHMENT_MESSAGE_SELF);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(DeliveryIndicatorHelper.class);
        DeliveryIndicatorHelper.setDeliveryIndicatorView(listItem.getDeliveryIndicator(),
                listItem.getTime(), viewHolder);

        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(),
                viewHolder.attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);

    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeIsAttachmentMessageContinuedSelf() {
        AttachmentMessageContinuedSelfListItem listItem = new AttachmentMessageContinuedSelfListItem
                (ID, mock(Attachment.class), NON_ZERO_TIME, mock(DeliveryIndicator.class),
                        false, data);

        mockStatic(AttachmentHelper.class);
        mockStatic(DeliveryIndicatorHelper.class);
        AttachmentMessageContinuedSelfViewHolder viewHolder =
                mock(AttachmentMessageContinuedSelfViewHolder.class);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType
                .ATTACHMENT_MESSAGE_CONTINUED_SELF);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(DeliveryIndicatorHelper.class);
        DeliveryIndicatorHelper.setDeliveryIndicatorView(listItem.getDeliveryIndicator(),
                listItem.getTime(), viewHolder);

        verifyStatic(AttachmentHelper.class);
        AttachmentHelper.setUpAttachmentImages(listItem.getAttachment(),
                viewHolder.attachmentPlaceholder, viewHolder.attachmentThumbnail, viewHolder.message);

    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeSImpleMessageContinuedSelf() {
        mockStatic(DeliveryIndicatorHelper.class);
        mockStatic(MessageStyleHelper.class);
        final SimpleMessageContinuedSelfViewHolder viewHolder =
                mock(SimpleMessageContinuedSelfViewHolder.class);
        final SimpleMessageContinuedSelfListItem listItem =
                mock(SimpleMessageContinuedSelfListItem.class);
        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.SIMPLE_MESSAGE_CONTINUED_SELF);
        when(baseListItemList.get(POSITION)).thenReturn(mock(SimpleMessageContinuedSelfListItem.class));
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verifyStatic(DeliveryIndicatorHelper.class);
        DeliveryIndicatorHelper.
                setDeliveryIndicatorView(listItem.getDeliveryIndicator(), listItem.getTime(), viewHolder);

        verifyStatic(MessageStyleHelper.class);
        MessageStyleHelper.setMessage(viewHolder.message, listItem.getMessage());
        MessageStyleHelper.setMessageStyle(true, listItem.isFadeBackground(),
                viewHolder.message, listItem.getMessage());
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeSimpleMessageOther() {
        mockStatic(Kayako.class);
        mockStatic(ImageUtils.class);
        mockStatic(MessageStyleHelper.class);
        final SimpleMessageOtherListItem listItem = mock(SimpleMessageOtherListItem.class);
        listItem.setChannel(null);
        SimpleMessageOtherViewHolder viewHolder = mock(SimpleMessageOtherViewHolder.class);
        viewHolder.channel = channel;
        viewHolder.time = timeTextView;

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.SIMPLE_MESSAGE_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(mock(SimpleMessageOtherListItem.class));
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(channel, times(1)).setVisibility(View.GONE);

        verifyStatic(MessageStyleHelper.class);
        MessageStyleHelper.setMessage(viewHolder.message, listItem.getMessage());
        MessageStyleHelper.setMessageStyle(false, false,
                viewHolder.message, listItem.getMessage());
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeSimpleMessageOtherElseCase() {
        mockStatic(Kayako.class);
        mockStatic(ImageUtils.class);
        mockStatic(MessageStyleHelper.class);

        SimpleMessageOtherViewHolder viewHolder = mock(SimpleMessageOtherViewHolder.class);
        viewHolder.channel = channel;
        viewHolder.time = timeTextView;

        final SimpleMessageOtherListItem listItem = new SimpleMessageOtherListItem(ID, "",
                "", new ChannelDecoration(POSITION), NON_ZERO_TIME, data);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.SIMPLE_MESSAGE_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(channel, times(1)).setVisibility(View.VISIBLE);
        verify(timeTextView, times(1)).setVisibility(View.VISIBLE);

        verifyStatic(MessageStyleHelper.class);
        MessageStyleHelper.setMessage(viewHolder.message, listItem.getMessage());
        MessageStyleHelper.setMessageStyle(false, false, viewHolder.message,
                listItem.getMessage());
    }


    @Test
    public void onBindViewHolderWhenMessengerListTypeSimpleMessageContinuedOther() {
        mockStatic(Kayako.class);
        mockStatic(ImageUtils.class);
        mockStatic(MessageStyleHelper.class);

        final SimpleMessageContinuedOtherViewHolder viewHolder =
                mock(SimpleMessageContinuedOtherViewHolder.class);
        viewHolder.time = this.timeTextView;
        final SimpleMessageContinuedOtherListItem listItem = new
                SimpleMessageContinuedOtherListItem(ID, "", ZERO_TIME, data);


        when(viewHolder.getItemViewType()).
                thenReturn(MessengerListType.SIMPLE_MESSAGE_CONTINUED_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(this.timeTextView, times(1)).setVisibility(View.GONE);
        verifyStatic(MessageStyleHelper.class);
        MessageStyleHelper.setMessage(viewHolder.message, listItem.getMessage());
        MessageStyleHelper.setMessageStyle(false, false,
                viewHolder.message, listItem.getMessage());
    }

    @Test
    public void onBindViewHolderWhenMessengerListTypeSimpleMessageContinuedOtherElseCase() {
        mockStatic(Kayako.class);
        mockStatic(ImageUtils.class);
        mockStatic(MessageStyleHelper.class);

        final SimpleMessageContinuedOtherViewHolder viewHolder =
                mock(SimpleMessageContinuedOtherViewHolder.class);
        viewHolder.time = this.timeTextView;
        final SimpleMessageContinuedOtherListItem listItem =
                new SimpleMessageContinuedOtherListItem(ID, "", NON_ZERO_TIME, data);

        when(viewHolder.getItemViewType()).thenReturn(MessengerListType.SIMPLE_MESSAGE_CONTINUED_OTHER);
        when(baseListItemList.get(POSITION)).thenReturn(listItem);
        when(recyclerViewScrollAdapter.getData()).thenReturn(baseListItemList);
        when(Kayako.getApplicationContext()).thenReturn(mockContext);

        messengerAdapter.onBindViewHolder(viewHolder, POSITION);

        verify(this.timeTextView, times(1)).setVisibility(View.VISIBLE);
        verifyStatic(MessageStyleHelper.class);
        MessageStyleHelper.setMessage(viewHolder.message, listItem.getMessage());
        MessageStyleHelper.setMessageStyle(false, false,
                viewHolder.message, listItem.getMessage());
    }

    @Test
    public void setOnItemClickListener() throws Exception {
        messengerAdapter.setOnItemClickListener(mItemClickListener);
        Field field = messengerAdapter.getClass().getDeclaredField("mItemClickListener");
        field.setAccessible(true);
        assertEquals(field.get(messengerAdapter), mItemClickListener);
    }

    @Test
    public void setOnAvatarClickListener() throws Exception {
        messengerAdapter.setOnAvatarClickListener(mAvatarClickListener);
        Field field = messengerAdapter.getClass().getDeclaredField("mAvatarClickListener");
        field.setAccessible(true);
        assertEquals(field.get(messengerAdapter), mAvatarClickListener);
    }

    @Test
    public void setOnAttachmentClickListener() throws Exception {
        //Arrange
        messengerAdapter.setOnAttachmentClickListener(mAttachmentClickListener);

        //Act
        Field field = messengerAdapter.getClass().getDeclaredField("mAttachmentClickListener");
        field.setAccessible(true);

        //Assert
        assertEquals(field.get(messengerAdapter), mAttachmentClickListener);
    }

    @Test
    public void setAvatarClickListenerOnView() {
        messengerAdapter.setOnAvatarClickListener(mAvatarClickListener);
        messengerAdapter.setAvatarClickListenerOnView(mockView, 0, ID, data);
    }

    @Test
    public void setItemClickListenerOnView() {
        messengerAdapter.setOnItemClickListener(mItemClickListener);
        messengerAdapter.setItemClickListenerOnView(mockView, 0, ID, data);
    }

    @Test
    public void setAttachmentClickListenerOnView() {
        messengerAdapter.setOnAttachmentClickListener(mAttachmentClickListener);
        messengerAdapter.setAttachmentClickListenerOnView(mockView, 0, ID,
                mock(Attachment.class), mock(View.class), data);
    }

    @Test
    public void getItemViewType() {
        //Arrange
        int position = 1;
        when(baseListItemList.get(position)).thenReturn(mock(BaseListItem.class));
        messengerAdapter.setData(baseListItemList);

        //Act
        int res = messengerAdapter.getItemViewType(position);

        //Assert
        assertThat(res, is(equalTo(messengerAdapter.getData().get(position).getItemType())));
    }

    @Test
    public void constructorTest() throws Exception {
        //Arrange
        messengerAdapter = new MessengerAdapter(baseListItemList);
        Field f = messengerAdapter.getClass().getSuperclass().getDeclaredField("mValues");
        f.setAccessible(true);

        //Act
        List<BaseListItem> expectedbaseListItemList = (List<BaseListItem>) f.get(messengerAdapter);

        //Assert
        assertEquals(baseListItemList, expectedbaseListItemList);
    }


    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsSimpleMessageSelf() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_simple_message_self), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.SIMPLE_MESSAGE_SELF);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(SimpleMessageSelfViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsSimpleMessageOther() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_simple_message_other), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.SIMPLE_MESSAGE_OTHER);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(SimpleMessageOtherViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsSimpleMessageContinuedSelf() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_simple_message_continued_self), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.SIMPLE_MESSAGE_CONTINUED_SELF);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(SimpleMessageContinuedSelfViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsSimpleMessageContinuedOther() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_simple_message_continued_other), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.SIMPLE_MESSAGE_CONTINUED_OTHER);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(SimpleMessageContinuedOtherViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsAttachmentMessageSelf() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_attachment_message_self), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.ATTACHMENT_MESSAGE_SELF);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(AttachmentMessageSelfViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsAttachmentMessageOther() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_attachment_message_other), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.ATTACHMENT_MESSAGE_OTHER);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(AttachmentMessageOtherViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsAttachmentMessageContinuedSelf() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_attachment_message_continued_self), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.ATTACHMENT_MESSAGE_CONTINUED_SELF);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(AttachmentMessageContinuedSelfViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsAttachmentMessageContinuedOther() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_attachment_message_continued_other), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.ATTACHMENT_MESSAGE_CONTINUED_OTHER);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(AttachmentMessageContinuedOtherViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsDateSperator() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_date_separator), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.DATE_SEPARATOR);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(DateSeparatorViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsUnreadSperator() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_unread_separator), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.UNREAD_SEPARATOR);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(UnreadSeparatorViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsEmptySperator() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_empty_separator), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.EMPTY_SEPARATOR);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(EmptyViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsBotMessage() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_bot_message_other), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.BOT_MESSAGE);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(BotMessageViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsSystemMessage() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_system_message), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.SYSTEM_MESSAGE);

        //Arrange
        collector.checkThat(viewHolder, is(instanceOf(SystemMessageViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsInputFieldEmail() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_input_field), eq(mockParent), eq(false))).thenReturn(mockView);
        when(mockView.getContext()).thenReturn(mockContext);
        when(mockView.findViewById(R.id.input_layout)).thenReturn(linearLayout);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.INPUT_FIELD_EMAIL);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(InputEmailViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsInputFeedbackRating() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_input_field), eq(mockParent), eq(false))).thenReturn(mockView);
        when(mockView.getContext()).thenReturn(mockContext);
        when(mockView.findViewById(R.id.input_layout)).thenReturn(linearLayout);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.INPUT_FIELD_FEEDBACK_RATING);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(InputFeedbackRatingViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsInputFeedbackComment() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_input_field), eq(mockParent), eq(false))).thenReturn(mockView);
        when(mockView.getContext()).thenReturn(mockContext);
        when(mockView.findViewById(R.id.input_layout)).thenReturn(linearLayout);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.INPUT_FIELD_FEEDBACK_COMMENT);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(InputFeedbackCommentViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsInputFeedbackCompleted() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_input_field), eq(mockParent), eq(false))).thenReturn(mockView);
        when(mockView.getContext()).thenReturn(mockContext);
        when(mockView.findViewById(R.id.input_layout)).thenReturn(linearLayout);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.INPUT_FIELD_FEEDBACK_COMPLETED);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(InputFeedbackCompletedViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenMessengerListTypeIsTypingFooter() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_messenger_typing), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                MessengerListType.TYPING_FOOTER);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(TypingViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }

    @Test
    public void onCreateViewHolderWhenDefaultSection() {
        //Arrange
        when(mockParent.getContext()).thenReturn(mockContext);
        when(LayoutInflater.from(mockContext)).thenReturn(mockInflater);
        when(mockInflater.inflate(eq(R.layout.ko__list_item_loading), eq(mockParent), eq(false))).thenReturn(mockView);

        //Act
        RecyclerView.ViewHolder viewHolder = messengerAdapter.onCreateViewHolder(mockParent,
                ListType.LOADING_ITEM);

        //Assert
        collector.checkThat(viewHolder, is(instanceOf(LoadingViewHolder.class)));
        collector.checkThat(viewHolder.itemView, is(equalTo(mockView)));
    }
}
