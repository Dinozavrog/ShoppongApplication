package com.example.feature_login.presentation.ui

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
import com.example.core.domain.AppConfigRepository
import com.example.core.domain.model.AppConfig
import com.example.core_compose.theme.AppTheme
import com.example.feature_login.R
import com.example.feature_login.di.LoginComponent
import com.example.feature_login.di.LoginComponentProvider
import com.example.feature_login.presentation.navigation.loginScreen
import com.example.feature_login.presentation.navigation.registerScreen
import com.example.navigation.data.RouteScreens
import com.example.navigation.domain.MainRouter
import javax.inject.Inject

class LoginFragment : Fragment() {

    private val component: LoginComponent by lazy {
        LoginComponentProvider.component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    @Inject
    internal lateinit var router: MainRouter

    @Inject lateinit var appConfigRepository: AppConfigRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.findViewById<ComposeView>(R.id.composeView).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AppTheme {
                    val startDestination =
                        when (appConfigRepository.getAppConfig()) {
                            AppConfig.FIRST_ENTRANCE -> registerScreen
                            AppConfig.LOG_OUT -> loginScreen
                            AppConfig.LOGIN -> loginScreen
                        }
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = startDestination) {
                        registerScreen(
                            component,
                            { router.navigateTo(RouteScreens.HomeScreen) }
                        )

                        loginScreen(
                            component,
                            { router.navigateTo(RouteScreens.HomeScreen) }
                        )
                    }
                }
            }
        }
        return view
    }


    companion object {
        private const val MODE = "MODE"

        fun newInstance(mode: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(MODE, mode)
                }
            }
    }
}