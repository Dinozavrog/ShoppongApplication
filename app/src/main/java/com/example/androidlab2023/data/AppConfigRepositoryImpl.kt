package com.example.androidlab2023.data

import com.example.core.domain.AppConfigRepository
import com.example.core.domain.model.AppConfig
import com.example.navigation.domain.MainRouter
import javax.inject.Inject

class AppConfigRepositoryImpl @Inject constructor(
    private val router: MainRouter
): AppConfigRepository {

    override fun getAppConfig(): AppConfig {
        TODO("Not yet implemented")
    }

    override suspend fun updateAppConfig(appConfig: AppConfig) {
        TODO("Not yet implemented")
    }
}