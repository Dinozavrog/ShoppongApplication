package com.example.navigation.domain

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.feature_basket.presentation.BasketFragment
import com.example.feature_login.presentation.LoginFragment
import com.example.feature_products.presentation.HomeFragment
import com.example.feature_profile.presentation.ProfileFragment
import com.example.navigation.data.RouteScreens
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val context: Context,
    private val ciceroneRouter: Router
): MainRouter {

    private var lastScreen: RouteScreens? = null

    private fun createFragmentInstance(screen: RouteScreens): Fragment = when (screen) {
        is RouteScreens.BasketScreen -> BasketFragment.newInstance()
        is RouteScreens.HomeScreen -> HomeFragment.newInstance()
        is RouteScreens.ProfileScreen -> ProfileFragment.newInstance()
        is RouteScreens.LoginScreen -> LoginFragment.newInstance(screen.mode)
    }

    override fun newRootScreen(screen: RouteScreens) {
        lastScreen = screen
        ciceroneRouter.newRootScreen(
            createCiceroneScreen(screen)
        )
    }

    override fun navigateTo(screen: RouteScreens) {
        lastScreen = screen
        ciceroneRouter.navigateTo(
            createCiceroneScreen(screen)
        )
    }

    override fun replaceScreen(screen: RouteScreens) {
        lastScreen = screen
        ciceroneRouter.replaceScreen(createCiceroneScreen(screen))
    }

    override fun exit() {
        lastScreen = null
        ciceroneRouter.exit()
    }

    private fun createCiceroneScreen(screen: RouteScreens): FragmentScreen =
        object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment =
                createFragmentInstance(screen)
        }
}