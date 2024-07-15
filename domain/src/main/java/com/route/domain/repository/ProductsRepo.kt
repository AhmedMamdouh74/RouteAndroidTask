package com.route.domain.repository

import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow

interface ProductsRepo {
    suspend fun getProducts():Flow<ResultWrapper< List<ProductsItem?>?>>
}