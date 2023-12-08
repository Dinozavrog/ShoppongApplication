package com.example.navigation.di

import androidx.annotation.RestrictTo
import com.example.navigation.domain.MainRouter
import kotlin.properties.Delegates

interface NavigationDepends {

    val router: MainRouter
}

interface NavigationDependsProvider {


    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: NavigationDepends

    companion object : NavigationDependsProvider by NavigationDependsStore
}

object NavigationDependsStore : NavigationDependsProvider {

    override var dependencies: NavigationDepends by Delegates.notNull()
}

