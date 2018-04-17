package com.sp.standardapplication.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/*
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

/**
 * Created by meet.parabiya on 6/15/2015.
 */

/**
 * Class Usage : Shared Preference for Application
 */


public class PreferenceHelper {

	// Shared Preferences
	SharedPreferences mSharedPreferences;

	// Editor for Shared preferences
	Editor editor;

	// Context
	Context _context;

	// Shared mSharedPreferences mode
	int PRIVATE_MODE = 0;

	// Sharedpref file name
	//TODO:PREF_NAME change
	private static final String PREF_NAME = "cfo_g";
	public static final String ACCESS_TOKEN = "access-token";
	public static final String USER_PROFILE = "user-profile";
	private static final String DEVICE_TOKEN = "deviceToken";
	private static final String DEVICE_TYPE = "deviceType";
	private static final String OS_VERSION = "osVersion";
	private static final String NOTIFICATION_ID = "notificationId";
//    private static final String LAT = "lat";
//    private static final String LON = "lon";

	public PreferenceHelper(Context context) {
		this._context = context;
		mSharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

	}


	public void setAccessToken(String accessToken) {
		editor = mSharedPreferences.edit();
		editor.putString(ACCESS_TOKEN, accessToken);
		editor.commit();
	}

	public int getNotificationId() {
		return mSharedPreferences.getInt(NOTIFICATION_ID, 0);
	}

	public void setNotificationId(int notificationId) {
		editor = mSharedPreferences.edit();
		editor.putInt(NOTIFICATION_ID, notificationId);
		editor.commit();
	}

	public String getAccessToken() {
		return mSharedPreferences.getString(ACCESS_TOKEN, null);
	}

	//Clear session details
	public void logoutUser() {
		//clear data from shared mSharedPreferences
		editor = mSharedPreferences.edit();
		editor.clear();
		editor.commit();

		//After logout rediredt user to ....
	}

	public void setDeviceToken(String deviceToken) {
		editor = mSharedPreferences.edit();
		editor.putString(DEVICE_TOKEN, deviceToken);
		editor.commit();
	}

	public String getDeviceToken() {
		return mSharedPreferences.getString(DEVICE_TOKEN, "");
	}

	public void setDeviceTypeAndOS(String deviceType, String osVersion) {
		editor = mSharedPreferences.edit();
		editor.putString(DEVICE_TYPE, deviceType);
		editor.putString(OS_VERSION, osVersion);
		editor.commit();
	}

	public String getDeviceType() {
		return mSharedPreferences.getString(DEVICE_TYPE, null);
	}

	public String getOsVersion() {
		return mSharedPreferences.getString(OS_VERSION, null);
	}


}
