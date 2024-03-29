package com.lilliemountain.ticketbookingapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String PREF_NAME = "com.lilliemountain.PREF_NAME";

    private static SharedPrefManager sInstance;
    private final SharedPreferences mPref;

    private SharedPrefManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SharedPrefManager(context);
        }
    }

    public static synchronized SharedPrefManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(SharedPrefManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setValue(String key,String value) {
        mPref.edit()
                .putString(key, value)
                .commit();
    }
    public void deleteValue(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public String getValue(String key) {
        return mPref.getString(key, null);
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}