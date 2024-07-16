package com.route.data.repository

import com.route.data.handler.NetworkHandler
import com.route.data.datasourcecontract.ProductsDataSourceContract
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val productsDataSourceContract: ProductsDataSourceContract,private val networkHandler: NetworkHandler) :
    ProductsRepo {
    override suspend fun getProducts(): Flow<ResultWrapper<List<ProductsItem?>?>> {
        return if (networkHandler.isOnline.isInitialized){
            productsDataSourceContract.getProductsFromAPI()
        }else{
            productsDataSourceContract.getProductsFromLocalDB()
        }
    }
}