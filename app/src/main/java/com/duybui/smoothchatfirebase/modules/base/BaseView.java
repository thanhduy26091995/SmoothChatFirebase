package com.duybui.smoothchatfirebase.modules.base;

/**
 * Created by buivu on 21/08/2017.
 */

public interface BaseView {
    boolean isNetworkConnect();
    void networkConnectError();
    void showDialogLoading();
    void hideDialogLoading();
    void showProgressDialog();
    void hideProgressDialog();
    void showDialogError(int resId);
}
