package com.route.data.handler

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class NetworkHandler {

    var isOnline = MutableLiveData<Boolean>()
}