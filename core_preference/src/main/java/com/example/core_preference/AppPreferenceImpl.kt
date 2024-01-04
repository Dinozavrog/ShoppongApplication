package com.example.core_preference

import android.content.Context
import android.content.SharedPreferences

internal class AppPreferenceImpl(
    context: Context
): AppPreference {
    object AppConfigPref {

        private const val PREF_APP_CONFIG = "app_config_pref"

        fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREF_APP_CONFIG, Context.MODE_PRIVATE)
        }
    }

    private val sharedPreferencesAppConfig = AppConfigPref.getSharedPreferences(context)

    override fun setAppConfig(appConfig: Int) {
        sharedPreferencesAppConfig
            .edit()
            .putInt(APP_CONFIG_KEY, appConfig)
            .commit()
    }

    override fun getAppConfig(): Int = sharedPreferencesAppConfig.getInt(APP_CONFIG_KEY, APP_CONFIG_DEFAULT)

    companion object {
        const val APP_CONFIG_KEY = "app config"
        const val APP_CONFIG_DEFAULT = -999999
    }
}