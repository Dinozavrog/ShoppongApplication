package com.example.feature_products.presentation.di

import androidx.lifecycle.ViewModel
import com.example.core.di.FeatureScope
import com.example.feature_products.presentation.presentation.HomeFragment
import com.example.feature_products.presentation.presentation.ui.home_screen.HomeScreenViewModel
import com.example.feature_products.presentation.presentation.ui.product_screen.ProductViewModel
import dagger.Component

@[FeatureScope
Component(
    dependencies = [HomeDepends::class]
)]

internal interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(depends: HomeDepends): HomeComponent
    }

    fun getHomeScreenViewModel(): HomeScreenViewModel

}

internal object HomeComponentProvider: ViewModel() {
    val component: HomeComponent by lazy {
        DaggerHomeComponent.factory().create(HomeDependsProvider.dependencies)
    }
}