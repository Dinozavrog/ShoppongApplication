package com.example.feature_login.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.core_compose.di.daggerViewModel
import com.example.feature_login.di.LoginComponent
import com.example.feature_login.presentation.ui.screens.login_screen.LoginRoute

const val loginScreen = "LoginScreen"

fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null) {
    this.navigate(loginScreen, navOptions)
}

internal fun NavGraphBuilder.loginScreen(
    component: LoginComponent,
    navigateToHomeScreen: () -> Unit
) {
    composable(route = loginScreen) {
        val viewModel = daggerViewModel {
            component.getLoginViewModel()
        }
        LoginRoute(
            viewModel = viewModel,
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}