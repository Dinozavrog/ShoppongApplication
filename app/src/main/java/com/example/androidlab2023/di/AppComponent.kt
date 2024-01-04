package com.example.androidlab2023.di

import android.content.Context
import com.example.androidlab2023.ShoppingApp
import com.example.androidlab2023.di.annotation.AppScope
import com.example.androidlab2023.di.module.AppModule
import com.example.androidlab2023.di.subcomponent.UIComponent
import com.example.feature_login.di.LoginDepends
import com.example.feature_products.presentation.di.HomeDepends
import com.example.navigation.di.NavigationDepends
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent: NavigationDepends, LoginDepends, HomeDepends {

    fun inject(app: ShoppingApp)

    fun getUIComponentFactory(): UIComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}