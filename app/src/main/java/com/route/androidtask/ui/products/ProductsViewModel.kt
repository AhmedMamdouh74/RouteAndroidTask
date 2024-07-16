package com.route.androidtask.ui.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.androidtask.MyApplication
import com.route.data.handler.NetworkHandler
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import com.route.domain.usecase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase,
    private val networkHandler: NetworkHandler
) :
    ViewModel() {
    private val _productsState =
        MutableStateFlow<ResultWrapper<List<ProductsItem?>?>>(ResultWrapper.Loading)
    val productsState: StateFlow<ResultWrapper<List<ProductsItem?>?>>
        get() = _productsState
    private val myApplication = MyApplication()

    init {
        getProducts()
    }


    fun getProducts() {
        networkHandler.isOnline.postValue(myApplication.isNetworkConnected.value)

        viewModelScope.launch {
            Log.d(TAG, "getProducts: ${myApplication.isNetworkConnected.value}")
            productsUseCase.invoke().collect { result ->
                _productsState.value = result
            }
        }
    }
    companion object{
        const val TAG="ProductsViewModel"
    }
}