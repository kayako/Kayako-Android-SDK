package com.kayako.sdk.android.k5.articlelistpage;

import com.kayako.sdk.helpcenter.HelpCenter;
import com.kayako.sdk.helpcenter.articles.Article;

import java.util.List;
import java.util.Locale;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public class ArticleListRepository implements ArticleListContract.Data {

    private HelpCenter mHelpCenter;
    private List<Article> mArticles;
    private long mSectionId;

    public ArticleListRepository(String helpCenterUrl, Locale locale) {
        mHelpCenter = new HelpCenter(helpCenterUrl, locale);
    }

    @Override
    public List<Article> getArticles(long sectionId, int offset, int limit, boolean useCache) {
        if (!useCache || mArticles == null || mArticles.size() == 0 || mSectionId != sectionId) {
            mSectionId = sectionId;
            return mArticles = mHelpCenter.getArticles(sectionId, offset, limit);
        } else {
            return mArticles;
        }
    }

    /**
     * isCached should only be used to check if the first set of items (offset=0) are cached
     *
     * @return
     */
    public boolean isCached(long sectionId) {
        return mArticles != null && mArticles.size() != 0 && mSectionId == sectionId;
    }

}
