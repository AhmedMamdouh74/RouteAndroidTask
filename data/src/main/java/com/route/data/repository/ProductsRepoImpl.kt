package com.route.data.repository

import com.route.data.datasourcecontract.ProductsDataSourceContract
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val productsDataSourceContract: ProductsDataSourceContract) :
    ProductsRepo {
    override suspend fun getProducts(): Flow<ResultWrapper<List<ProductsItem?>?>> {
        return productsDataSourceContract.getProducts()
    }
}