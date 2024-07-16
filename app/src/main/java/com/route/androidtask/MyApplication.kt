package com.route.androidtask

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow

@HiltAndroidApp
class MyApplication : Application() {
    var isNetworkConnected = MutableStateFlow(false)

    override fun onCreate() {
        super.onCreate()
        listenToNetworkConnectivity()
    }

    @SuppressLint("CheckResult")
    private fun listenToNetworkConnectivity() {
        ReactiveNetwork.observeInternetConnectivity().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io()).subscribe { isConnected: Boolean ->
                Log.d(TAG, "Connected to internet: $isConnected")
                Log.d(TAG, "Connected to internet: ${isNetworkConnected.value}")

                isNetworkConnected.value = isConnected


            }
    }

    companion object {
        const val TAG = "MyApplication"
    }
}