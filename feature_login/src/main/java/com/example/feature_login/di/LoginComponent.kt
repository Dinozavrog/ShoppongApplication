package com.example.feature_login.di

import androidx.lifecycle.ViewModel
import com.example.core.di.FeatureScope
import com.example.feature_login.presentation.ui.LoginFragment
import com.example.feature_login.presentation.ui.screens.login_screen.LoginViewModel
import com.example.feature_login.presentation.ui.screens.register_screen.RegisterViewModel
import dagger.Component

@[FeatureScope
Component(
    dependencies = [LoginDepends::class]
)]
internal interface LoginComponent {

    fun inject(fragment: LoginFragment)

    @Component.Factory
    interface Factory {
        fun create(depends: LoginDepends): LoginComponent
    }

    fun getRegisterViewModel(): RegisterViewModel

    fun getLoginViewModel(): LoginViewModel
}

internal object LoginComponentProvider: ViewModel() {
    val component: LoginComponent by lazy {
        DaggerLoginComponent.factory().create(LoginDependsProvider.dependencies)
    }
}