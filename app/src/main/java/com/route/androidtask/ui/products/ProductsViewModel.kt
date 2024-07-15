package com.route.androidtask.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import com.route.domain.usecase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsUseCase: ProductsUseCase) :
    ViewModel() {
    private val _productsState =
        MutableStateFlow<ResultWrapper<List<ProductsItem?>?>>(ResultWrapper.Loading)
    val productsState: StateFlow<ResultWrapper<List<ProductsItem?>?>>
        get() = _productsState
    init {
        getProducts()
    }
      fun getProducts() {
        viewModelScope.launch {
            productsUseCase.invoke().collect {result->
                _productsState.value = result
            }
        }
    }
}