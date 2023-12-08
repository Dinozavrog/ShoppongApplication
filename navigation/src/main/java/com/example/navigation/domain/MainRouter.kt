package com.example.navigation.domain

import com.example.navigation.data.RouteScreens

interface MainRouter {

    fun newRootScreen(screen: RouteScreens)

    fun navigateTo(screen: RouteScreens)

    fun replaceScreen(screen: RouteScreens)

    fun exit()
}