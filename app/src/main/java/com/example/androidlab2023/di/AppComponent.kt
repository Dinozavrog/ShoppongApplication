package com.example.androidlab2023.di

import android.content.Context
import com.example.androidlab2023.MainActivity
import com.example.androidlab2023.ShoppingApp
import com.example.androidlab2023.di.annotation.AppScope
import com.example.androidlab2023.di.module.AppModule
import com.example.androidlab2023.di.module.DomainModule
import com.example.androidlab2023.di.subcomponent.UIComponent
import com.example.navigation.di.NavigationDepends
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent: NavigationDepends {

    fun inject(app: ShoppingApp)

    fun getUIComponentFactory(): UIComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}