package com.duybui.smoothchatfirebase.modules.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duybui.smoothchatfirebase.R;
import com.duybui.smoothchatfirebase.utils.components.InternetConnection;
import com.duybui.smoothchatfirebase.utils.message_dialog.DialogResultItem;
import com.duybui.smoothchatfirebase.utils.message_dialog.MessageDialogHelper;
import com.duybui.smoothchatfirebase.utils.message_dialog.MessageDialogManger;
import com.duybui.smoothchatfirebase.utils.message_dialog.OnClickDialogListener;
import com.duybui.smoothchatfirebase.utils.message_dialog.TypeMessageDialog;

import butterknife.ButterKnife;

/**
 * Created by tantr on 9/11/2017.
 */

public abstract class BaseFragment extends Fragment implements BaseView, OnClickDialogListener, View.OnClickListener {
    protected View rootView;
    protected final int DIALOG_LOADING = 540;
    protected final int DIALOG_ERROR = 541;
    protected final int DIALOG_SUCCESS = 542;
    protected MessageDialogManger mMessageDialogManger;
    protected ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMessageDialogManger = new MessageDialogManger();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = onCreateView(inflater, container);
        ButterKnife.bind(this, rootView);
        initPresenter();
        setDataToUI();
        addActionClickListener();
        return rootView;
    }

    abstract View onCreateView(LayoutInflater inflater, ViewGroup container);

    abstract void setDataToUI();

    abstract void addActionClickListener();


    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(getActivity()).unbind();
    }

    abstract void initPresenter();


    protected void showDialogLoading(Integer dialogId, String content) {
        mMessageDialogManger.onCreate(new MessageDialogHelper.MessageDialogBuilder()
                .setTypeMessageDialog(TypeMessageDialog.MESSAGEDIALOG_TYPE_LOADING)
                .setDialogId(dialogId)
                .setTitleDialog(getResources().getString(R.string.dialog_title))
                .setContentDialog(content)
                .setOnClickDialogListener(this)
                .build(getActivity()));
        mMessageDialogManger.onShow();
    }

    protected void showDialogError(Integer dialogId, String content) {
        mMessageDialogManger.onCreate(new MessageDialogHelper.MessageDialogBuilder()
                .setTypeMessageDialog(TypeMessageDialog.MESSAGEDIALOG_TYPE_ERROR)
                .setDialogId(dialogId)
                .setContentDialog(content)
                .setOnClickDialogListener(this)
                .build(getActivity()));
        mMessageDialogManger.onShow();
    }

    protected void showDialogSuccess(Integer dialogId, String content) {
        mMessageDialogManger.onCreate(new MessageDialogHelper.MessageDialogBuilder()
                .setTypeMessageDialog(TypeMessageDialog.MESSAGEDIALOG_TYPE_SUCCESS)
                .setDialogId(dialogId)
                .setTitleDialog(getResources().getString(R.string.dialog_title))
                .setContentDialog(content)
                .setOnClickDialogListener(this)
                .build(getActivity()));
        mMessageDialogManger.onShow();
    }

    @Override
    public void onClickDialog(DialogResultItem dialogResulltItem) {
        switch (dialogResulltItem.getDialogId()) {
            case DIALOG_ERROR:
                mMessageDialogManger.onDimiss();
                break;
            case DIALOG_SUCCESS:
                mMessageDialogManger.onDimiss();
                break;
        }
    }

    @Override
    public void showDialogError(int resId) {
        showDialogError(DIALOG_ERROR, getResources().getString(resId));
    }

    @Override
    public void showDialogLoading() {
        showDialogLoading(DIALOG_LOADING, "Loading");
    }

    @Override
    public void hideDialogLoading() {
        mMessageDialogManger.onDimiss();
    }

    @Override
    public void showProgressDialog() {
        showProgress();
    }

    @Override
    public void hideProgressDialog() {
        hideProgress();
    }

    @Override
    public boolean isNetworkConnect() {
        if (InternetConnection.getInstance().isOnline(getActivity())) {
            return true;
        }
        return false;
    }

    @Override
    public void networkConnectError() {
        showDialogError(DIALOG_ERROR, getResources().getString(R.string.error_internet));
    }

    protected void showProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    protected void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
