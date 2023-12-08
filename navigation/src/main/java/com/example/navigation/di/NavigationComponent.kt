package com.example.navigation.di

import androidx.lifecycle.ViewModel
import com.example.core.di.FeatureScope
import com.example.navigation.di.module.NavigationModule
import com.example.navigation.presentation.ShopNavigationFragment
import dagger.Component

@[FeatureScope
Component(
    dependencies = [NavigationDepends::class],
    modules = [NavigationModule::class]
)]
internal interface NavigationComponent {

    fun inject(fragment: ShopNavigationFragment)

    @Component.Factory
    interface Factory {
        fun create(depends: NavigationDepends): NavigationComponent
    }
}

internal class NavigationComponentViewModel : ViewModel() {

    val navigationComponent =
        DaggerNavigationComponent.factory().create(NavigationDependsProvider.dependencies)
}