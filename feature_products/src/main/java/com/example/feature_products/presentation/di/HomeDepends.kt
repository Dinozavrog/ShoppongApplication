package com.example.feature_products.presentation.di

import androidx.annotation.RestrictTo
import com.example.feature_products.presentation.domain.repository.ProductsRepository
import com.example.feature_toasts.ToastService
import com.example.navigation.domain.MainRouter
import kotlin.properties.Delegates

interface HomeDepends {
    val router: MainRouter
    val toastService: ToastService
    val productsRepository: ProductsRepository
}

interface HomeDependsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: HomeDepends

    companion object : HomeDependsProvider by HomeDependsStore
}

object HomeDependsStore : HomeDependsProvider {

    override var dependencies: HomeDepends by Delegates.notNull()
}