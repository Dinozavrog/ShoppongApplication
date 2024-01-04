package com.example.androidlab2023

import android.os.Bundle
import android.view.View
import com.example.androidlab2023.databinding.ActivityMainBinding
import com.example.androidlab2023.ui.BaseMainActivity

class MainActivity : BaseMainActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw Throwable()

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.getUIComponentFactory().create().inject(this)
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.launchFirstScreen()

        val activityView: View = binding.mainFragmentContainer
        toastService.setActivityView(activityView)
    }
}
