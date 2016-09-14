package com.kayako.sdk.android.k5.articlepage;

import com.kayako.sdk.android.k5.common.mvp.BasePresenter;
import com.kayako.sdk.android.k5.common.mvp.BaseView;
import com.kayako.sdk.helpcenter.articles.Article;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public interface ArticlePageContract {

    interface View extends BaseView {

        void setAuthorName(String name);

        void setAuthorAvatar(String avatarUrl);

        void setArticleTitle(String title);

        void setArticleDirectoryPath(String path);

        void setArticleContent(String htmlContent);

        void showArticleContent();

        void hideArticleContent();

        void hideContentScrollbarsWhileAllowingScroll();

    }

    interface Presenter extends BasePresenter<ArticlePageContract.View> {

        void initPage(Article article);

        void onContentLoaded();
    }
}
