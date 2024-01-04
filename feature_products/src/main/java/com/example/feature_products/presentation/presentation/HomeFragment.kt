package com.example.feature_products.presentation.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core_compose.theme.AppTheme
import com.example.feature_products.R
import com.example.feature_products.presentation.di.HomeComponent
import com.example.feature_products.presentation.di.HomeComponentProvider
import com.example.feature_products.presentation.presentation.navigation.homeScreen
import com.example.navigation.data.RouteScreens
import com.example.navigation.domain.MainRouter
import javax.inject.Inject

class HomeFragment : Fragment() {

    private val component: HomeComponent by lazy {
        HomeComponentProvider.component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    @Inject
    internal lateinit var router: MainRouter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<ComposeView>(R.id.composeView).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AppTheme {
                    val startDestination = homeScreen
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = startDestination) {
                        homeScreen(
                            component,
                            { router.navigateTo(RouteScreens.ProfileScreen) }
                        )
                    }
                }
            }
        }
        return view
    }


    companion object {
        fun newInstance() = HomeFragment()
    }
}