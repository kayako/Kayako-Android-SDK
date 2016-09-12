package com.kayako.sdk.android.k5.articlelistpage;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.kayako.sdk.android.k5.R;
import com.kayako.sdk.android.k5.activities.KayakoArticleActivity;
import com.kayako.sdk.android.k5.common.adapter.EndlessRecyclerViewScrollAdapter;
import com.kayako.sdk.android.k5.common.adapter.ListItemRecyclerViewAdapter;
import com.kayako.sdk.android.k5.common.data.ListItem;
import com.kayako.sdk.android.k5.common.fragments.BaseListFragment;
import com.kayako.sdk.android.k5.common.task.BackgroundTask;
import com.kayako.sdk.helpcenter.articles.Article;

import java.util.List;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public class ArticleListFragment extends BaseListFragment implements ArticleListContract.View, EndlessRecyclerViewScrollAdapter.OnLoadMoreListener, ListItemRecyclerViewAdapter.OnItemClickListener {

    public static final String ARG_SECTION_ID = "section-id";

    private BackgroundTask mTaskToLoadData;
    private BackgroundTask mTaskToLoadMoreData;

    public static ArticleListFragment newInstance(long sectionId) {
        Bundle bundle = new Bundle();
        bundle.putLong(ARG_SECTION_ID, sectionId);

        ArticleListFragment articleListFragment = new ArticleListFragment();
        articleListFragment.setArguments(bundle);
        return articleListFragment;
    }

    public ArticleListFragment() {
    }

    ArticleListContract.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = ArticleListFactory.getPresenter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_SECTION_ID)) {
            mPresenter.initPage(getArguments().getLong(ARG_SECTION_ID));
        } else {
            // TODO: Throw Exception or close activity???
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cancelBackgroundTasks();
        mTaskToLoadData = null;
        mTaskToLoadMoreData = null;
    }

    @Override
    public void setUpList(List<ListItem> items) {
        ArticleListAdapter articleListAdapter = new ArticleListAdapter(items, this);
        initList(articleListAdapter, this);
    }

    @Override
    public void addItemsToList(List<ListItem> items) {
        super.addToList(items);
    }

    @Override
    public void showLoadingMoreItemsProgress() {
        super.showLoadMoreProgress();
    }

    @Override
    public void hideLoadingMoreItemsProgress() {
        super.hideLoadMoreProgress();
    }

    @Override
    public void setListHasMoreItems(boolean hasMoreItems) {
        super.setHasMoreItems(hasMoreItems);
    }

    protected void reloadPage() {
        mPresenter.reloadPage();
    }

    @Override
    public void startBackgroundTaskToLoadData() {
        cancelTask(mTaskToLoadData);

        mTaskToLoadData = (BackgroundTask) new BackgroundTask(getActivity()) {
            @Override
            protected boolean performInBackground() {
                return mPresenter.fetchDataInBackground();
            }

            @Override
            protected void performOnCompletion(boolean isSuccessful) {
                mPresenter.onDataLoaded(isSuccessful);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    @Override
    public void startBackgroundTaskToLoadMoreData() {
        // TODO How many times would this be called? load more should be called one at a time
        // TODO: How do ensure that the order is maintained. SERIAL EXECUTOR?
        mTaskToLoadMoreData = (BackgroundTask) new BackgroundTask(getActivity()) {
            @Override
            protected boolean performInBackground() {
                return mPresenter.fetchMoreDataInBackground();
            }

            @Override
            protected void performOnCompletion(boolean isSuccessful) {
                mPresenter.onMoreDataLoaded(isSuccessful);
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }

    @Override
    public void showOnlyListView() {
        super.showListViewAndHideOthers();
    }

    @Override
    public void showOnlyEmptyView() {
        super.showEmptyViewAndHideOthers(null, null);
    }

    @Override
    public void showOnlyErrorView() {
        super.showErrorViewAndHideOthers(null, null, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadPage();
            }
        });
    }

    @Override
    public void showOnlyLoadingView() {
        super.showLoadingViewAndHideOthers();
    }

    @Override
    public void loadMoreItems() {
        mPresenter.loadMoreData();
    }

    @Override
    public void onItemClick(ListItem listItem) {
        mPresenter.onClickListItem(listItem);
    }

    @Override
    public void openArticleActivity(Article article) {
        startActivity(KayakoArticleActivity.getIntent(getContext(),article));
    }


    private void cancelTask(BackgroundTask task) {
        if (task != null) {
            task.cancelTask();
        }
    }

    protected void cancelBackgroundTasks() {
        cancelTask(mTaskToLoadData);
        cancelTask(mTaskToLoadMoreData);
    }


}
