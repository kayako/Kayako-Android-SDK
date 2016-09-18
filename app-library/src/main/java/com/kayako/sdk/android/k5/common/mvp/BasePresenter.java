package com.kayako.sdk.android.k5.common.mvp;

/**
 * @author Neil Mathew <neil.mathew@kayako.com>
 */
public interface BasePresenter<T extends BaseView> {
    void setView(T view);
}
