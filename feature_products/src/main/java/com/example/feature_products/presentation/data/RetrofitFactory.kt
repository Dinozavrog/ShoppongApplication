package com.example.feature_products.presentation.data

import com.example.feature_products.presentation.data.service.ProductsService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitFactory {

    private const val BASE_URL = "https://fakestoreapi.com"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl(BASE_URL)
        .build()
        ?: throw RuntimeException("Retrofit not build")


    val retrofitProductsService =
        retrofit.create(ProductsService::class.java)
            ?: throw RuntimeException("Don't create Service")


}