package com.example.androidlab2023.di.module

import android.content.Context
import com.example.androidlab2023.data.AppConfigRepositoryImpl
import com.example.androidlab2023.di.annotation.AppScope
import com.example.androidlab2023.presentation.UIResourceProviderImpl
import com.example.core.domain.AppConfigRepository
import com.example.core.presentation.UIResourceProvider
import com.example.core_database.ShopDao
import com.example.core_database.getShopDao
import com.example.core_preference.AppPreference
import com.example.core_preference.AppPreferenceProvider
import com.example.feature_products.presentation.domain.repository.getProductsRepository
import com.example.feature_toasts.getToastService
import com.example.feature_user_data.UserRepository
import com.example.feature_user_data.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @[Binds AppScope]
    fun bindAppConfigRepository(impl: AppConfigRepositoryImpl): AppConfigRepository

    @[Binds AppScope]
    fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @[Binds AppScope]
    fun bindUIResourceProvider(impl: UIResourceProviderImpl): UIResourceProvider

    companion object {

        @[Provides AppScope]
        fun provideDao(context: Context): ShopDao = getShopDao(context)

        @[Provides AppScope]
        fun provideToastService(context: Context, uiResourceProvider: UIResourceProvider) = getToastService(context, uiResourceProvider)

        @[Provides AppScope]
        fun provideAppPreference(context: Context): AppPreference =
            AppPreferenceProvider.getInstance(context)

        @[Provides AppScope]
        fun provideProductsRepository() = getProductsRepository()
    }
}