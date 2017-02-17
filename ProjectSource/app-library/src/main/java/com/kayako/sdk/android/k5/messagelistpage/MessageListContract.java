package com.kayako.sdk.android.k5.messagelistpage;

import android.support.annotation.Nullable;

import com.kayako.sdk.android.k5.common.adapter.BaseListItem;
import com.kayako.sdk.android.k5.common.mvp.BasePresenter;
import com.kayako.sdk.android.k5.common.mvp.BaseView;

import java.util.List;

public class MessageListContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<MessageListContract.View> {

        void initPage();

        void closePage();

    }

    interface ConfigureView {

        void setupList(List<BaseListItem> conversation);

        void showEmptyView();

        void showErrorView();

        void showLoadingView();

    }
}
