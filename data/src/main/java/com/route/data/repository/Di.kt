package com.route.data.repository

import com.route.domain.repository.ProductsRepo
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
    abstract fun bindsProductsRepo(productsRepoImpl: ProductsRepoImpl): ProductsRepo
}