package com.example.feature_user_data

import com.example.feature_user_data.model.UserModel

interface UserRepository {

    suspend fun insertUser(user: UserModel)

    suspend fun deleteUser(user: UserModel)

    suspend fun getUser(email: String): UserModel?
}