package com.route.domain.common


sealed class ResultWrapper<out T>{

    data class Error(val error:Exception):ResultWrapper<Nothing>()
    data class Success<T>(val data:T):ResultWrapper<T>()
    object Loading:ResultWrapper<Nothing>()


}