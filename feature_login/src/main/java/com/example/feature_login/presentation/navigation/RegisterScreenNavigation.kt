package com.example.feature_login.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.core_compose.di.daggerViewModel
import com.example.feature_login.di.LoginComponent
import com.example.feature_login.presentation.ui.screens.register_screen.RegisterRoute

const val registerScreen = "RegisterScreen"

fun NavController.navigateToRegisterScreen(navOptions: NavOptions? = null) {
    this.navigate(registerScreen, navOptions)
}
internal fun NavGraphBuilder.registerScreen(
    component: LoginComponent,
    navigateToHomeScreen: () -> Unit,
) {
    composable(route = registerScreen) {
        val viewModel = daggerViewModel {
            component.getRegisterViewModel()
        }
        RegisterRoute(
            viewModel = viewModel,
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}