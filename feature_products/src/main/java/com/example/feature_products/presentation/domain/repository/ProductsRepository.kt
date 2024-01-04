package com.example.feature_products.presentation.domain.repository

import com.example.feature_products.presentation.data.repository.ProductsRepositoryImpl
import com.example.feature_products.presentation.domain.model.ProductModel

interface ProductsRepository {

    suspend fun getProducts(): List<ProductModel>

    suspend fun getProductById(id: Int): ProductModel
}

fun getProductsRepository() : ProductsRepository = ProductsRepositoryImpl()