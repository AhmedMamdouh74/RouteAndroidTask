package com.route.data.datasource

import com.route.data.api.WepServices
import com.route.data.database.ProductsDao
import com.route.data.datasourcecontract.ProductsDataSourceContract
import com.route.data.model.ProductResponseDto
import com.route.data.model.ProductsItemDto
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class ProductsDataSourceContractImplTest {
    private lateinit var productsDataSource: ProductsDataSourceContract
    private val webServices = mockk<WepServices>()
    private val productsDao = mockk<ProductsDao>()

    @Before
    fun setUp() {
        productsDataSource = ProductsDataSourceImpl(webServices,productsDao)
    }

    @Test
    fun `when call getProducts from data source it should get data from api`() = runTest {
        val productsItemDtoList = listOf(ProductsItemDto(), ProductsItemDto())
        val productsResponse = Response.success(ProductResponseDto(products = productsItemDtoList))
        coEvery { webServices.getProducts() } returns productsResponse
        webServices.getProducts()
        coVerify(exactly = 1) { webServices.getProducts() }
        val firstEmission = productsDataSource.getProductsFromAPI().first()
        assert(firstEmission is ResultWrapper.Loading)
        val result =
            productsDataSource.getProductsFromAPI()
                .filterIsInstance<ResultWrapper.Success<List<ProductsItem?>?>>()
                .first()
        TestCase.assertEquals(2, result.data?.size)
    }
}