package com.example.androidlab2023.data

import com.example.core.domain.AppConfigRepository
import com.example.core.domain.model.AppConfig
import com.example.core_preference.AppPreference
import javax.inject.Inject

class AppConfigRepositoryImpl @Inject constructor(
    private val appPreference: AppPreference,
): AppConfigRepository {

    override fun getAppConfig(): AppConfig =
        when (appPreference.getAppConfig()) {
            LOGIN -> AppConfig.LOGIN
            LOG_OUT -> AppConfig.LOG_OUT
            else -> AppConfig.FIRST_ENTRANCE
    }

    override suspend fun updateAppConfig(appConfig: AppConfig) {
        val config = when (appConfig) {
            AppConfig.FIRST_ENTRANCE -> FIRST_ENTRANCE
            AppConfig.LOGIN -> LOGIN
            AppConfig.LOG_OUT -> LOG_OUT
        }
        appPreference.setAppConfig(config)
    }

    companion object {
        private const val FIRST_ENTRANCE = 0
        private const val LOGIN = 1
        private const val LOG_OUT = 2
    }
}