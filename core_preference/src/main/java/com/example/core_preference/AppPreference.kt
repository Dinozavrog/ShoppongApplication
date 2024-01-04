package com.example.core_preference

import android.content.Context

interface AppPreference {

    fun setAppConfig(appConfig: Int)

    fun getAppConfig(): Int

}

object AppPreferenceProvider {
    private var appPreference : AppPreference? = null

    private val LOCK = Any()

    fun getInstance(context: Context): AppPreference {
        synchronized(LOCK) {
            appPreference?.let { return it }
            val instance =
                AppPreferenceImpl(context)
            appPreference = instance
            return instance
        }
    }
}