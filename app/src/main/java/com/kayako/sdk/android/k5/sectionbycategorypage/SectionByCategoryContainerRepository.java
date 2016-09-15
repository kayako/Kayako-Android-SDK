package com.kayako.sdk.android.k5.sectionbycategorypage;

import com.kayako.sdk.helpcenter.HelpCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public class SectionByCategoryContainerRepository implements SectionByCategoryContainerContract.Data {

    private List<com.kayako.sdk.helpcenter.locale.Locale> mLocales = null;

    private HelpCenter mHelpCenter;

    public SectionByCategoryContainerRepository(String helpCenterUrl, Locale locale) {
        mHelpCenter = new HelpCenter(helpCenterUrl, locale);
    }

    // TODO: Force Refresh? Caching?

    @Override
    public List<com.kayako.sdk.helpcenter.locale.Locale> getPublicLocales(boolean useCacheIfAvailable) {

        if (!useCacheIfAvailable || mLocales == null) {
            mLocales = mHelpCenter.getLocales();
        }

        if (mLocales == null || mLocales.size() == 0) {
            return mLocales;
        } else {
            List<com.kayako.sdk.helpcenter.locale.Locale> publicLocales = new ArrayList<>();
            for (com.kayako.sdk.helpcenter.locale.Locale locale : mLocales) {
                if (locale.isPublic()) {
                    publicLocales.add(locale);
                }
            }

            return publicLocales;
        }
    }
}
