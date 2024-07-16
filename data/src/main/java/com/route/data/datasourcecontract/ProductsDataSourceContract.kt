package com.route.data.datasourcecontract

import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow

interface ProductsDataSourceContract {
    suspend fun getProductsFromAPI(): Flow<ResultWrapper<List<ProductsItem?>?>>
    suspend fun getProductsFromLocalDB(): Flow<ResultWrapper<List<ProductsItem?>?>>
}