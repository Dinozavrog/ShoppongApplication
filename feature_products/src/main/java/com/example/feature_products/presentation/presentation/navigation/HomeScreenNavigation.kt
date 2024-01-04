package com.example.feature_products.presentation.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.core_compose.di.daggerViewModel
import com.example.feature_products.presentation.di.HomeComponent
import com.example.feature_products.presentation.presentation.ui.home_screen.HomeScreenRoute

const val homeScreen = "HomeScreen"
fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeScreen, navOptions)
}

internal fun NavGraphBuilder.homeScreen(
    component: HomeComponent,
    navigateToProfileScreen: () -> Unit,
) {
    composable(route = homeScreen) {
        val viewModel = daggerViewModel {
            component.getHomeScreenViewModel()
        }
        HomeScreenRoute(
            viewModel = viewModel,
            navigateToProfileScreen = navigateToProfileScreen
        )
    }
}