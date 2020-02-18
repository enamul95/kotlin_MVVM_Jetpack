package com.haqueit.bd.kotlin_mvvm_jetpack.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Custom_alert {

    public static SweetAlertDialog showProgressDialog(Activity activity){
        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Please wait...");
        pDialog.setCanceledOnTouchOutside(false);
        return pDialog;

    }


    public static void showInternetConnectionMessage(Activity activity){


        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Internet Connection").setContentText("No Internet Connection").show();


    }

    public static boolean isOnline(Activity activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }


}
