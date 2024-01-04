package com.example.feature_products.presentation.data.mapper

import com.example.feature_products.presentation.data.model.ProductItem
import com.example.feature_products.presentation.domain.model.ProductModel

internal fun ProductItem.toProductModel(): ProductModel =
    ProductModel(
        id = id,
        name = title,
        description = description,
        icon = image
    )