package com.duybui.smoothchatfirebase.utils.helper;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by buivu on 21/03/2018.
 */

public final class InformHelper {
    private InformHelper() {

    }

    public static void showToast(Activity activity, String content) {
        Toast.makeText(activity, content, Toast.LENGTH_SHORT).show();
    }
}
