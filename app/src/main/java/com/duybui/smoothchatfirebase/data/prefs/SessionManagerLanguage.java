package com.duybui.smoothchatfirebase.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.duybui.smoothchatfirebase.R;
import com.duybui.smoothchatfirebase.modules.base.BaseApplication;


/**
 * Created by Admin on 8/28/2017.
 */

public class SessionManagerLanguage {
    private static final String PREF_NAME = "languge_pref";
    private static final String KEY_LANGUAGE = "language";
    public static final String KEY_IS_CLICK_LANGUAGE = "clickLanguage";


    private static SessionManagerLanguage instance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;

    private SessionManagerLanguage() {
        mSharedPreferences = BaseApplication.getInstance().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static SessionManagerLanguage getInstance() {
        if (instance == null) {
            instance = new SessionManagerLanguage();
        }
        return instance;
    }

    public String getLanguage() {
        return mSharedPreferences.getString(KEY_LANGUAGE, BaseApplication.getInstance().getApplicationContext().getResources().getString(R.string.language_default));
    }

    //create language session
    public void createLanguageSession(String language) {
        editor.putString(KEY_LANGUAGE, language);
        //commit
        editor.commit();
    }


}
