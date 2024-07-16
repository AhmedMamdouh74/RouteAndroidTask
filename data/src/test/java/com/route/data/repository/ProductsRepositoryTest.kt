package com.route.data.repository

import com.route.data.datasourcecontract.ProductsDataSourceContract
import com.route.data.handler.NetworkHandler
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import com.route.domain.repository.ProductsRepo
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductsRepositoryTest {
    private lateinit var productsRepo: ProductsRepo
    private val categoryDataSourceContract = mockk<ProductsDataSourceContract>()
    private val networkHandler=NetworkHandler()

    @Before
    fun setUp() {
        productsRepo = ProductsRepoImpl(categoryDataSourceContract,networkHandler)
    }

    @Test
    fun `verify when call products getData it should call Products data source`() = runTest {
        val productsList = listOf(
            ProductsItem(),
            ProductsItem()
        )

        val response = ResultWrapper.Success<List<ProductsItem?>?>(data = productsList)
        coEvery { productsRepo.getProducts() } returns flowOf(
            response
        )

        val result = productsRepo.getProducts()
            .first()
        assert(result is ResultWrapper.Success)
        result as ResultWrapper.Success
        coVerify(exactly = 1) {productsRepo.getProducts() }
        TestCase.assertEquals(
            2, result.data?.size
        )


    }
}