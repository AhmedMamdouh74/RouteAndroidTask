package com.route.data.handler

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Di {
    @Provides
    @Singleton
    fun bindsNetWorkHandler(): NetworkHandler {
        return NetworkHandler()
    }
}