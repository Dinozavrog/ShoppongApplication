package com.example.core.domain

import com.example.core.domain.model.AppConfig

interface AppConfigRepository {

    fun getAppConfig(): AppConfig

    suspend fun updateAppConfig(appConfig: AppConfig)
}