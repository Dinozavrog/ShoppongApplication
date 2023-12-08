package com.example.navigation.data

sealed class RouteScreens {

    object HomeScreen : RouteScreens()

    object ProfileScreen: RouteScreens()

    object BasketScreen: RouteScreens()

    data class LoginScreen(val mode: String): RouteScreens()

}