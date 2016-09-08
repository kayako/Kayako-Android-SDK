package com.kayako.sdk.android.k5.searcharticlepage;

import com.kayako.sdk.android.k5.common.data.ListItem;
import com.kayako.sdk.android.k5.common.mvp.BaseData;
import com.kayako.sdk.android.k5.common.mvp.BasePresenter;
import com.kayako.sdk.android.k5.common.mvp.BaseView;
import com.kayako.sdk.helpcenter.articles.Article;

import java.util.List;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public interface SearchArticleContract {

    interface Data extends BaseData {
        List<Article> searchArticles(String query, int offset, int limit);
    }

    interface View extends BaseView {

        void setUpList(List<ListItem> items);

        void showOnlyListView();

        void showOnlyEmptyView();

        void showOnlyErrorView();

        void showOnlyLoadingView();

        void startBackgroundTask();

    }

    interface Presenter extends BasePresenter<SearchArticleContract.View> {

        void initPage(long sectionId);

        boolean loadDataInBackground();

        void onDataLoaded(boolean isSuccessful);

        void onClickListItem(ListItem listItem);

        void reloadPage();
    }

}
