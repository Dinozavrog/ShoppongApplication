package com.example.feature_products.presentation.data.repository

import com.example.feature_products.presentation.data.RetrofitFactory
import com.example.feature_products.presentation.data.mapper.toProductModel
import com.example.feature_products.presentation.domain.model.ProductModel
import com.example.feature_products.presentation.domain.repository.ProductsRepository

class ProductsRepositoryImpl(): ProductsRepository {

    private val productsService = RetrofitFactory.retrofitProductsService
    override suspend fun getProducts(): List<ProductModel> =
        productsService.getAllProducts().map { it.toProductModel() }

    override suspend fun getProductById(id: Int): ProductModel =
        productsService.getProductById(id).toProductModel()
}