package com.example.feature_products.presentation.domain.usecase

import com.example.feature_products.presentation.domain.model.ProductModel
import com.example.feature_products.presentation.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductsRepository,
) {
    suspend operator fun invoke(): List<ProductModel> =
        repository.getProducts()
}