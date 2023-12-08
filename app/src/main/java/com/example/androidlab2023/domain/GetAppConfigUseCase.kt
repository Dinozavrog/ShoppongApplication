package com.example.androidlab2023.domain

import com.example.core.domain.AppConfigRepository
import com.example.core.domain.model.AppConfig
import javax.inject.Inject

class GetAppConfigUseCase @Inject constructor(
    private val repository: AppConfigRepository
) {
    operator fun invoke(): AppConfig = repository.getAppConfig()
}