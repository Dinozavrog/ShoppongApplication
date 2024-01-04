package com.example.feature_products.presentation.data.service

import com.example.feature_products.presentation.data.model.ProductItem
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ProductsService {

    @GET("/products")
    suspend fun getAllProducts(
    ): List <ProductItem>

    @GET("/products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductItem

}