package com.route.androidtask

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first

@HiltAndroidApp
class MyApplication : Application() {
    private val _isNetworkConnected = MutableStateFlow(false)
    val isNetworkConnected :StateFlow<Boolean> get() = _isNetworkConnected

    override fun onCreate() {
        super.onCreate()
        listenToNetworkConnectivity()
    }

    @SuppressLint("CheckResult")
    private fun listenToNetworkConnectivity() {
        ReactiveNetwork.observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                { isConnected: Boolean ->
                    Log.d(TAG, "Connected to internet: $isConnected")
                    Log.d(TAG, "Previous state: ")
                    _isNetworkConnected.value=isConnected
                    Log.d(TAG, "Updated state: ")
                },
                { error ->
                    Log.e(TAG, "Error observing network connectivity", error)
                }
            )
    }

    companion object {
        const val TAG = "MyApplication"
    }
}
