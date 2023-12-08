package com.example.navigation.di.module

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.navigation.presentation.ShopNavigationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface NavigationModule {

    @IntoMap
    @ViewModelKey(ShopNavigationViewModel::class)
    @Binds
    fun bindShopNavigationViewModel(impl: ShopNavigationViewModel): ViewModel
}