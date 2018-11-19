package com.maryang.jetpack.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.maryang.jetpack.ui.base.BaseApplication;

public class NetworkChecker {

    public static boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication.get().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
