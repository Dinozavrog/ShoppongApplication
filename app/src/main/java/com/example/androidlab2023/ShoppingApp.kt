package com.example.androidlab2023

import android.app.Application
import android.content.Context
import com.example.androidlab2023.di.AppComponent
import com.example.androidlab2023.di.DaggerAppComponent
import com.example.feature_login.di.LoginDependsStore
import com.example.feature_products.presentation.di.HomeDependsStore
import com.example.navigation.di.NavigationDependsStore

class ShoppingApp: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        NavigationDependsStore.dependencies = appComponent
        LoginDependsStore.dependencies = appComponent
        HomeDependsStore.dependencies = appComponent
        appComponent.inject(this)
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is ShoppingApp -> appComponent
        else -> applicationContext.appComponent
    }