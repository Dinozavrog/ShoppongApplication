package com.example.navigation.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.core.presentation.ViewModelFactory
import com.example.navigation.R
import com.example.navigation.databinding.FragmentShopNavigationBinding
import com.example.navigation.di.NavigationComponent
import com.example.navigation.di.NavigationComponentViewModel
import com.example.navigation.utils.setupWithNavController
import javax.inject.Inject

class ShopNavigationFragment : Fragment() {

    private var _binding: FragmentShopNavigationBinding? = null
    private val binding
        get() = _binding ?: throw Throwable()

    private var onBackPressedCallback: OnBackPressedCallback? = null


    private val component: NavigationComponent by lazy {
        ViewModelProvider(this).get<NavigationComponentViewModel>()
            .navigationComponent
    }

    private val navController: NavController by lazy {
        val navHostFragment = childFragmentManager
            .findFragmentById(R.id.shopNavigationFragmentContainer) as NavHostFragment
        navHostFragment.navController
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ShopNavigationViewModel
            by viewModels(factoryProducer = { viewModelFactory })

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    private fun setCustomBackPress() {
        onBackPressedCallback = requireActivity().onBackPressedDispatcher.addCallback(this) {

            val isNavControllerHaveBackStack =
                navController.currentDestination?.let { destination ->
                    destination.id != destination.parent?.startDestinationId
                } ?: false

            if (isNavControllerHaveBackStack)
                navController.navigateUp()
            else {
                isEnabled = viewModel.popBackStack()
                if (!isEnabled) {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentShopNavigationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomNavigationController()
        initVmObserve()
    }

    private fun setBottomNavigationController() {

        val onItemClickListener: (Int) -> Unit = { tabId ->
            navController.navigate(tabId)
            viewModel.addToBackStack(tabId)
        }
        binding.bottomNavigation.setupWithNavController(navController, onItemClickListener)
    }

    private fun initVmObserve() {
        viewModel.fromBackStackOpenedTabId.observe(viewLifecycleOwner) {
            binding.bottomNavigation.selectedItemId = it
        }
        binding.bottomNavigation.isVisible = true
    }


    override fun onResume() {
        setCustomBackPress()
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        onBackPressedCallback?.remove()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}