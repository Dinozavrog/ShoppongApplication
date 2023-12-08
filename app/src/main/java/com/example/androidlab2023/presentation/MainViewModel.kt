package com.example.androidlab2023.presentation

import com.example.androidlab2023.domain.GetAppConfigUseCase
import com.example.core.domain.model.AppConfig
import com.example.navigation.domain.MainRouter
import com.example.navigation.data.RouteScreens
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: MainRouter,
    private val getAppConfigUseCase: GetAppConfigUseCase
) {

    fun launchFirstScreen() {
        val screen = when (getAppConfigUseCase()) {
            AppConfig.FIRST_ENTRANCE -> RouteScreens.LoginScreen("FIRST_ENTRANCE")
            AppConfig.LOGIN -> RouteScreens.LoginScreen("LOGIN")
            AppConfig.LOG_OUT -> RouteScreens.LoginScreen("LOG_OUT")
        }
        router.newRootScreen(screen)
    }
}