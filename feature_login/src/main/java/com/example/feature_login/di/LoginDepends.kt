package com.example.feature_login.di

import androidx.annotation.RestrictTo
import com.example.core.domain.AppConfigRepository
import com.example.feature_toasts.ToastService
import com.example.feature_user_data.UserRepository
import com.example.navigation.domain.MainRouter
import kotlin.properties.Delegates

interface LoginDepends {
    val router: MainRouter
    val appConfigRepository: AppConfigRepository
    val toastService: ToastService
    val userRepository: UserRepository
}

interface LoginDependsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val dependencies: LoginDepends

    companion object : LoginDependsProvider by LoginDependsStore
}

object LoginDependsStore : LoginDependsProvider {

    override var dependencies: LoginDepends by Delegates.notNull()
}