package com.route.domain.usecase

import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepo: ProductsRepo) {
    suspend operator fun invoke(): Flow<ResultWrapper<List<ProductsItem?>?>> {
        return productsRepo.getProducts()

    }
}