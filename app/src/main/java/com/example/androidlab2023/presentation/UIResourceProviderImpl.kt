package com.example.androidlab2023.presentation

import android.content.Context
import com.example.core.presentation.UIResourceProvider
import javax.inject.Inject

class UIResourceProviderImpl @Inject constructor(
    private val context: Context,
): UIResourceProvider
{
    override fun getString(resourceId: Int): String {
        return context.getString(resourceId)
    }
}