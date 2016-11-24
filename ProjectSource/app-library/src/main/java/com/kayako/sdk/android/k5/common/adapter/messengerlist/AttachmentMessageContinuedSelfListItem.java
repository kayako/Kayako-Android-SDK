package com.kayako.sdk.android.k5.common.adapter.messengerlist;

import android.support.annotation.Nullable;

import com.kayako.sdk.android.k5.common.adapter.BaseDataListItem;

import java.util.Map;

public class AttachmentMessageContinuedSelfListItem extends BaseDataListItem {

    private String attachmentThumbnailUrl;
    private String message;
    private long time;

    public AttachmentMessageContinuedSelfListItem(@Nullable String attachmentThumbnailUrl, @Nullable String message, @Nullable long time, @Nullable Map<String, Object> data) {
        super(MessengerListType.ATTACHMENT_MESSAGE_CONTINUED_SELF,data);
        this.message = message;
        this.attachmentThumbnailUrl = attachmentThumbnailUrl;
        this.time = time;
    }

    public String getAttachmentThumbnailUrl() {
        return attachmentThumbnailUrl;
    }

    public void setAttachmentThumbnailUrl(String attachmentThumbnailUrl) {
        this.attachmentThumbnailUrl = attachmentThumbnailUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}