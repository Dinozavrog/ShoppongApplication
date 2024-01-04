package com.example.feature_products.presentation.presentation.ui.home_screen

import androidx.lifecycle.viewModelScope
import com.example.core.domain.CustomViewModel
import com.example.feature_products.presentation.domain.model.ProductModel
import com.example.feature_products.presentation.domain.usecase.GetProductsUseCase
import com.example.navigation.domain.MainRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class HomeScreenViewModel @Inject constructor(
    private val router: MainRouter,
    private val getProductsUseCase: GetProductsUseCase,
) : CustomViewModel() {

    private val _loading = MutableStateFlow(
        false
    )
    val loading = _loading.asStateFlow()

    private val _products = MutableStateFlow(
        emptyList<ProductModel>()
    )
    val products = _products.asStateFlow()

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch(errorHandler) {
            try {
                _loading.value = true
                _products.value = getProductsUseCase()
            } finally {
                _loading.value = false
            }
        }
    }
}