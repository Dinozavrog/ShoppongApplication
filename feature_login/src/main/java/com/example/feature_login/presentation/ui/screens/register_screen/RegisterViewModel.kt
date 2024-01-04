package com.example.feature_login.presentation.ui.screens.register_screen

import androidx.lifecycle.viewModelScope
import com.example.core.domain.AppConfigRepository
import com.example.core.domain.CustomViewModel
import com.example.core.domain.model.AppConfig
import com.example.feature_login.domain.RegisterUserUseCase
import com.example.feature_toasts.ToastService
import com.example.feature_user_data.model.UserModel
import com.example.navigation.data.RouteScreens
import com.example.navigation.domain.MainRouter
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class RegisterViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val toastService: ToastService,
    private val appConfigRepository: AppConfigRepository,
    private val router: MainRouter

): CustomViewModel() {

    private val localErrorHandler = CoroutineExceptionHandler { _, throwable ->
        _throwable.value = throwable
        toastService.showErrorToast(throwable)
    }

    fun registerUser(user: UserModel) {
        viewModelScope.launch(localErrorHandler) {
            registerUserUseCase(user)
            appConfigRepository.updateAppConfig(AppConfig.LOGIN)
            router.navigateTo(RouteScreens.HomeScreen)
        }
    }
}