package com.example.androidlab2023.di.module

import com.example.androidlab2023.di.annotation.AppScope
import com.example.androidlab2023.di.subcomponent.UIComponent
import com.example.navigation.domain.MainRouter
import com.example.navigation.domain.MainRouterImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [
        UIComponent::class
    ],
    includes = [
        DomainModule::class
    ]
)
interface AppModule {

    @[Binds AppScope]
    fun bindRouter(impl: MainRouterImpl): MainRouter

    companion object {

        @[AppScope Provides]
        fun provideCicerone(): Cicerone<Router> = Cicerone.create(Router())

        @[AppScope Provides]
        fun provideCiceroneRouter(cicerone: Cicerone<Router>): Router = cicerone.router

        @[AppScope Provides]
        fun provideCiceroneNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder =
            cicerone.getNavigatorHolder()
    }
}