package com.kayako.sdk.android.k5.messenger.data.conversation;

import android.os.Handler;

import com.kayako.sdk.android.k5.common.adapter.messengerlist.helper.UniqueSortedUpdatableResourceList;
import com.kayako.sdk.android.k5.core.MessengerPref;
import com.kayako.sdk.android.k5.messenger.data.conversation.unreadcounter.UnreadCounterRepository;
import com.kayako.sdk.auth.FingerprintAuth;
import com.kayako.sdk.base.callback.ItemCallback;
import com.kayako.sdk.base.callback.ListCallback;
import com.kayako.sdk.error.KayakoException;
import com.kayako.sdk.messenger.Messenger;
import com.kayako.sdk.messenger.conversation.Conversation;
import com.kayako.sdk.messenger.conversation.PostConversationBodyParams;

import java.util.Comparator;
import java.util.List;

public class ConversationStore {

    private static final Object key = new Object();
    private static ConversationStore mInstance;

    private UniqueSortedUpdatableResourceList<Conversation> mConversations = new UniqueSortedUpdatableResourceList<>();

    private ConversationStore() {
        mConversations.setSortComparator(new Comparator<Conversation>() {
            @Override
            public int compare(Conversation lhs, Conversation rhs) {
                long leftUpdatedTime = lhs.getUpdatedAt();
                long rightUpdatedTime = rhs.getUpdatedAt();

                // descending order of time
                if (leftUpdatedTime == rightUpdatedTime) {
                    return 0;
                } else if (leftUpdatedTime < rightUpdatedTime) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });
    }

    /**
     * Messenger is newly created because otherwise, it doesn't get cleared from memory when the user clears the cache
     *
     * @return
     */
    private Messenger getMessenger() {
        String url = MessengerPref.getInstance().getUrl();
        FingerprintAuth fingerprintAuth = new FingerprintAuth(MessengerPref.getInstance().getFingerprintId());
        return new Messenger(url, fingerprintAuth);
    }

    public static synchronized ConversationStore getInstance() {
        if (mInstance == null) {
            synchronized (key) {
                if (mInstance == null) {
                    return mInstance = new ConversationStore();
                }
            }
        }
        return mInstance;
    }

    public List<Conversation> getCachedConversations() {
        return mConversations.getList();
    }

    public void getConversation(final long conversationId, final ConversationLoaderCallback callback) {
        final Handler handler = new Handler();
        if (mConversations.exists(conversationId)) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onLoadConversation(mConversations.getElement(conversationId));
                }
            });
        }

        getMessenger().getConversation(conversationId, new ItemCallback<Conversation>() {
            @Override
            public void onSuccess(final Conversation item) {
                addConversation(item);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onLoadConversation(item);
                    }
                });
            }

            @Override
            public void onFailure(final KayakoException exception) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(exception);
                    }
                });
            }
        });
    }

    public void getConversations(final int offset, final int limit, final ConversationListLoaderCallback callback) {
        final Handler handler = new Handler();

        if (mConversations.getSize() > 0 && offset == 0) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onLoadConversations(getSortedConversations(offset, limit));
                }
            });
        }

        getMessenger().getConversationList(offset, limit, new ListCallback<Conversation>() {
            @Override
            public void onSuccess(final List<Conversation> items) {

                for (Conversation item : items) {
                    addConversation(item);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onLoadConversations(getSortedConversations(offset, limit));
                    }
                });
            }

            @Override
            public void onFailure(final KayakoException exception) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(exception);
                    }
                });
            }
        });
    }

    public void postConversation(final PostConversationBodyParams bodyParams, final ConversationLoaderCallback callback) {
        final Handler handler = new Handler();

        getMessenger().postConversation(bodyParams, new ItemCallback<Conversation>() {
            @Override
            public void onSuccess(final Conversation item) {
                addConversation(item);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback == null) {
                            return;
                        }

                        callback.onLoadConversation(item);
                    }
                });
            }

            @Override
            public void onFailure(final KayakoException exception) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback == null) {
                            return;
                        }

                        callback.onFailure(exception);
                    }
                });
            }
        });
    }

    public void clear() {
        mConversations = new UniqueSortedUpdatableResourceList<>();
    }

    private List<Conversation> getSortedConversations(int offset, int limit) {
        List<Conversation> conversations = getCachedConversations();

        if (conversations.size() > limit && offset < conversations.size() && offset <= limit) {
            return conversations.subList(offset, limit);
        } else {
            return conversations;
        }
    }

    public void addConversation(Conversation item) {
        mConversations.addElement(item.getId(), item);
        UnreadCounterRepository.refreshUnreadCounter();
    }

    public interface ConversationLoaderCallback {
        void onLoadConversation(Conversation conversation);

        void onFailure(KayakoException e);
    }

    public interface ConversationListLoaderCallback {
        void onLoadConversations(List<Conversation> conversationList);

        void onFailure(KayakoException e);
    }
}


