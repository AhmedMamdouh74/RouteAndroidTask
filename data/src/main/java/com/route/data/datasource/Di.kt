package com.route.data.datasource

import com.route.data.datasourcecontract.ProductsDataSourceContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    @Singleton
    abstract fun bindsProductsDataSourceContract(productsDataSourceImpl: ProductsDataSourceImpl):ProductsDataSourceContract
}