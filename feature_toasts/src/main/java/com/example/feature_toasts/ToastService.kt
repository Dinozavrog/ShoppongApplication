package com.example.feature_toasts

import android.content.Context
import android.view.View
import com.example.core.presentation.UIResourceProvider

interface ToastService {

    fun showToast(messageId: Int? = null, icon: Int, message: String? = null)

    fun showErrorToast(message: Throwable)

    fun setActivityView(view: View)

    fun detachActivityView()

}

fun getToastService(
    context: Context,
    uiResourceProvider: UIResourceProvider
): ToastService =
    ToastServiceImpl(context, uiResourceProvider)