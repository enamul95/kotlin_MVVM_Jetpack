package com.haqueit.bd.kotlin_mvvm_jetpack.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.pedant.SweetAlert.SweetAlertDialog
import com.haqueit.bd.kotlin_mvvm_jetpack.model.User_info_Data
import com.haqueit.bd.kotlin_mvvm_jetpack.retrofit.ApiService
import com.haqueit.bd.kotlin_mvvm_jetpack.util.Custom_alert
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class Users_Info_ViewModel : ViewModel() {
    private val apiService = ApiService()
    private val disposable = CompositeDisposable()

    var user_info_list = MutableLiveData<List<User_info_Data>>();


    fun getuser_info_list(activity: Activity) {
        var pDialog: SweetAlertDialog? =  Custom_alert.showProgressDialog(activity)
        pDialog?.show();


        disposable.add(apiService.getuser_info_service()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<User_info_Data>>() {
                override fun onSuccess(model: List<User_info_Data>) {

                    user_info_list.value = model;
                    Log.e("user_info_list--",model.toString())
                    pDialog?.dismiss()

                }

                override fun onError(e: Throwable) {
                    // pDialog?.hide()
                    Log.e("error--",e.toString())
                    pDialog?.dismiss()
                    e.printStackTrace()

                }

            })
        )
    }

}