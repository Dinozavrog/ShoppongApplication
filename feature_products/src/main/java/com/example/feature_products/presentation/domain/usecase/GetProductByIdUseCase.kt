package com.example.feature_products.presentation.domain.usecase

import com.example.feature_products.presentation.domain.model.ProductModel
import com.example.feature_products.presentation.domain.repository.ProductsRepository
import javax.inject.Inject

internal class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductsRepository
) {

    suspend operator fun invoke(id: Int): ProductModel {
        return repository.getProductById(id)
    }
}