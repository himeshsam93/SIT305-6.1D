package com.example.llmlearningapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREF_NAME = "LLM_APP";

    private static final String KEY_USERNAME = "username";
    private static final String KEY_FULLNAME = "fullname";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

//    public SessionManager(Context context) {
//
//        sharedPreferences =
//                context.getSharedPreferences(PREF_NAME,
//                        Context.MODE_PRIVATE);
//
//        editor = sharedPreferences.edit();
//    }

    public static void login(Context c, String user) {
        SharedPreferences sp = c.getSharedPreferences("session", 0);
        sp.edit().putString("user", user).apply();
    }

    // SAVE LOGIN SESSION
    public void saveUser(String username, String fullname) {

        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_FULLNAME, fullname);

        editor.apply();
    }

    // GET USERNAME
    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    // GET FULL NAME
    public String getFullname() {
        return sharedPreferences.getString(KEY_FULLNAME, "");
    }

    // LOGOUT
    public void logout() {

        editor.clear();
        editor.apply();
    }
}
