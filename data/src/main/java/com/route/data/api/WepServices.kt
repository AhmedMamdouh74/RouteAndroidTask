package com.route.data.api

import com.google.gson.GsonBuilder
import com.route.data.model.ProductResponseDto
import com.route.data.model.ProductsItemDto
import com.route.domain.common.ResultWrapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface WepServices {
    @GET("products")
    suspend fun getProducts(): Response<ProductResponseDto?>

    companion object {
        private const val BASE_URL = "https://dummyjson.com/"
        private const val TIME_OUT = 60L
        fun create(): WepServices {
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor {
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }.intercept(it)

                }.build()
            val retrofit: WepServices by lazy {
                Retrofit.Builder().addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().setLenient().create()
                    )
                ).baseUrl(BASE_URL).client(okHttpClient).build()
                    .create(WepServices::class.java)

            }
            return retrofit
        }


    }
}