package com.example.feature_login.domain

import com.example.feature_user_data.UserRepository
import com.example.feature_user_data.model.UserModel
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: UserModel) {
        repository.insertUser(user)
    }
}