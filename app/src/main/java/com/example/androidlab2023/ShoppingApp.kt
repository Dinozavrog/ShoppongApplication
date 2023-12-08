package com.example.androidlab2023

import android.app.Application
import android.content.Context
import com.example.androidlab2023.di.AppComponent
import com.example.androidlab2023.di.DaggerAppComponent
import com.example.navigation.di.NavigationDependsStore

class ShoppingApp: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        NavigationDependsStore.dependencies = appComponent
        appComponent.inject(this)
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is ShoppingApp -> appComponent
        else -> applicationContext.appComponent
    }