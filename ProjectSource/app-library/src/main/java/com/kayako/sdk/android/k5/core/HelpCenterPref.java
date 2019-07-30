package com.kayako.sdk.android.k5.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.URLUtil;

import java.util.Locale;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public class HelpCenterPref {
    final private String PREF_NAME = "kayako_help_center_info";
    final private String KEY_HELP_CENTER_URL = "help_center_url";
    final private String KEY_LOCALE_LANGUAGE = "locale_language";
    final private String KEY_LOCALE_REGION = "locale_region";

    private static HelpCenterPref mInstance;
    private static volatile SharedPreferences mPrefs;
    private Context mContext;

    public static void createInstance(Context context) {
        mInstance = new HelpCenterPref(context);
    }

    public static HelpCenterPref getInstance() {
        if (mInstance == null) {
            throw new NullPointerException("Please call Kayako.initialize() in your Application class");
        }
        return mInstance;
    }

    private HelpCenterPref(Context context) {
        mContext = context.getApplicationContext();
        if (mPrefs == null) {
            synchronized (HelpCenterPref.class) {
                if (mPrefs == null) {
                    mPrefs = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                }
            }
        }
    }

    public void setHelpCenterUrl(String url) {
        mPrefs.edit().putString(KEY_HELP_CENTER_URL, url).apply();
    }

    public String getHelpCenterUrl() {
        return mPrefs.getString(KEY_HELP_CENTER_URL, null);
    }

    public void setLocale(Locale locale) {
        mPrefs.edit().putString(KEY_LOCALE_LANGUAGE, locale.getLanguage()).apply();
        mPrefs.edit().putString(KEY_LOCALE_REGION, locale.getCountry()).apply();
    }

    public Locale getLocale() {
        String selectedLanguage = mPrefs.getString(KEY_LOCALE_LANGUAGE, null);
        String selectedRegion = mPrefs.getString(KEY_LOCALE_REGION, null);

        if (TextUtils.isEmpty(selectedLanguage)) {
            return mContext.getResources().getConfiguration().locale; // return device locale as default
        } else {
            return new Locale(selectedLanguage, selectedRegion);
        }
    }

    public void clearAll() {
        mPrefs.edit().clear().apply();
    }
}
