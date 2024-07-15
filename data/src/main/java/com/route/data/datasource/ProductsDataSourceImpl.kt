package com.route.data.datasource

import com.route.data.api.WepServices
import com.route.data.datasourcecontract.ProductsDataSourceContract
import com.route.data.model.convertTo
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsDataSourceImpl @Inject constructor(private val wepServices: WepServices) :
    ProductsDataSourceContract {
    override suspend fun getProducts(): Flow<ResultWrapper<List<ProductsItem?>?>> = flow {

        emit(ResultWrapper.Loading)
        val response = wepServices.getProducts()
        if (response.isSuccessful) {
            response.body()?.let { body ->
                val products = body.products?.map { it?.convertTo(ProductsItem::class.java) }
                emit(ResultWrapper.Success(products))
            } ?: emit(ResultWrapper.Error(Exception("Empty response body")))
        } else {
            emit(ResultWrapper.Error(Exception("API call failed with status: ${response.code()}")))
        }
    }.catch {
        emit(ResultWrapper.Error(Exception(it.message)))
    }


}
