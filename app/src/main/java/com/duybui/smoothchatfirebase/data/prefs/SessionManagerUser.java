package com.duybui.smoothchatfirebase.data.prefs;

import android.content.SharedPreferences;

import com.duybui.smoothchatfirebase.modules.base.BaseApplication;

import java.util.HashMap;

/**
 * Created by Admin on 8/24/2017.
 */

public class SessionManagerUser {

    private static SessionManagerUser instance;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private int PRIVATE_MODE = 0;

    private SessionManagerUser() {
        pref = BaseApplication.getInstance().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static SessionManagerUser getInstance() {
        if (instance == null) {
            instance = new SessionManagerUser();
        }
        return instance;
    }


    private static final String PREF_NAME = "DataUser";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_ID = "id";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_FULLNAME = "fullname";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_BIRTHDAY = "birthday";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_CREATE_DATE = "createDate";
    public static final String KEY_ALLOW_NOTIFICATION = "allowNotification";


    /**
     * Create login session
     */
//    public void createLoginSession(DataUser dataUser) {
//        // Storing login value as TRUE
//        editor.putBoolean(IS_LOGIN, true);
//        // Storing in pref
//        editor.putString(KEY_ID, dataUser.get_id());
//        editor.putString(KEY_TOKEN, dataUser.getToken());
//        editor.putString(KEY_EMAIL, dataUser.getEmail());
//        editor.putString(KEY_FULLNAME, dataUser.getFullname());
//        editor.putString(KEY_GENDER, String.valueOf(dataUser.getGender()));
//        editor.putString(KEY_PHONE, dataUser.getPhone());
//        editor.putString(KEY_IMAGE, dataUser.getAvatar());
//        editor.putString(KEY_ADDRESS, dataUser.getAddress());
//        editor.putString(KEY_BIRTHDAY, dataUser.getBirthday());
//        editor.putString(KEY_CREATE_DATE, dataUser.getCreated_at());
//        editor.putInt(KEY_ALLOW_NOTIFICATION, dataUser.getNotification());
//        // commit changes
//        editor.commit();
//    }


//    public void updateUserProfileSession(UsersResponse dataUser) {
//        // Storing in pref
//        editor.putString(KEY_ID, dataUser.getDataUser().get_id());
//        editor.putString(KEY_FULLNAME, dataUser.getDataUser().getFullname());
//        editor.putString(KEY_GENDER, String.valueOf(dataUser.getDataUser().getGender()));
//        editor.putString(KEY_ADDRESS, dataUser.getDataUser().getAddress());
//        editor.putString(KEY_PHONE, dataUser.getDataUser().getPhone());
//        editor.putString(KEY_BIRTHDAY, dataUser.getDataUser().getBirthday());
//        editor.putString(KEY_IMAGE, dataUser.getDataUser().getAvatar());
//        // commit changes
//        editor.commit();
//    }

    public void createLoginSessionFace() {
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    // Remove value whose key
    public void removeValue() {
        editor.remove(KEY_ID);
        editor.remove(KEY_FULLNAME);
        editor.remove(KEY_GENDER);
        editor.remove(KEY_ADDRESS);
        editor.remove(KEY_PHONE);
        editor.remove(KEY_BIRTHDAY);
        editor.remove(KEY_IMAGE);
        editor.commit();
    }


    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> data = new HashMap<String, String>();
        // data name
        data.put(KEY_ID, pref.getString(KEY_ID, ""));
        data.put(KEY_TOKEN, pref.getString(KEY_TOKEN, ""));
        data.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        data.put(KEY_FULLNAME, pref.getString(KEY_FULLNAME, null));
        data.put(KEY_GENDER, pref.getString(KEY_GENDER, ""));
        data.put(KEY_PHONE, pref.getString(KEY_PHONE, null));
        data.put(KEY_IMAGE, pref.getString(KEY_IMAGE, null));
        data.put(KEY_BIRTHDAY, pref.getString(KEY_BIRTHDAY, ""));
        data.put(KEY_ADDRESS, pref.getString(KEY_ADDRESS, null));
        data.put(KEY_CREATE_DATE, pref.getString(KEY_CREATE_DATE, null));
//        data.put(KEY_ALLOW_NOTIFICATION, pref.getString(KEY_ALLOW_NOTIFICATION, 0));
        // return data
        return data;
    }

    public String getUserToken() {
        return pref.getString(KEY_TOKEN, "");
    }

    public String getUserEmail() {
        return pref.getString(KEY_EMAIL, "");
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    //change noti
    public void addNotificationSession(int state) {
        editor.putInt(KEY_ALLOW_NOTIFICATION, state);
        editor.commit();
    }

    public int getNotification() {
        int state = pref.getInt(KEY_ALLOW_NOTIFICATION, 0);
        return state;
    }

}
