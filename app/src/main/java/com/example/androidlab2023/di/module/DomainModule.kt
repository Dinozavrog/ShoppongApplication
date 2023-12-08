package com.example.androidlab2023.di.module

import android.content.Context
import com.example.androidlab2023.data.AppConfigRepositoryImpl
import com.example.androidlab2023.di.annotation.AppScope
import com.example.androidlab2023.presentation.UIResourceProviderImpl
import com.example.core.domain.AppConfigRepository
import com.example.core.presentation.UIResourceProvider
import com.example.feature_toasts.getToastService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @[Binds AppScope]
    fun bindAppConfigRepository(impl: AppConfigRepositoryImpl): AppConfigRepository

    @[Binds AppScope]
    fun bindUIResourceProvider(impl: UIResourceProviderImpl): UIResourceProvider

    companion object {

        @[Provides AppScope]
        fun provideToastService(context: Context, uiResourceProvider: UIResourceProvider) = getToastService(context, uiResourceProvider)

    }
}