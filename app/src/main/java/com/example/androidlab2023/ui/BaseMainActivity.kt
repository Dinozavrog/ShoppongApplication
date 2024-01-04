package com.example.androidlab2023.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab2023.R
import com.example.androidlab2023.databinding.ActivityMainBinding
import com.example.androidlab2023.presentation.MainViewModel
import com.example.feature_toasts.ToastService
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

abstract class BaseMainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw Throwable()

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var toastService: ToastService

    private val navigator = AppNavigator(this, R.id.mainFragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.launchFirstScreen()

        val activityView: View = binding.mainFragmentContainer
        toastService.setActivityView(activityView)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator = navigator)
    }

    override fun onDestroy() {
        navigatorHolder.removeNavigator()
        toastService.detachActivityView()
        super.onDestroy()
    }

}