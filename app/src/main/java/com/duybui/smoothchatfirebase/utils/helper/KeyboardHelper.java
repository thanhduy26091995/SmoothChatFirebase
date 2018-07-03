package com.duybui.smoothchatfirebase.utils.helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by buivu on 14/03/2018.
 */

public final class KeyboardHelper {
    private KeyboardHelper() {

    }

    /**
     * Hiển thị keyboard, focus vào 1 view nào đó
     * @param activity
     * @param view
     */
    public static void showKeyboard(Activity activity, View view) {
        if (activity != null) {
            if (view != null) {
                view.requestFocus();
            }
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }
        }
    }

    /**
     * ẩn keyboard
     * @param activity
     */
    public static void hideKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null && activity.getCurrentFocus() != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                activity.getCurrentFocus().clearFocus();
            }
        }
    }

    /**
     * Ẩn keyboard từ 1 view nào đó
     * @param activity
     * @param view
     */
    public static void hideKeyboard(Activity activity, View view) {
        if (activity != null) {
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            } else {
                hideKeyboard(activity);
            }
        }
    }
}
