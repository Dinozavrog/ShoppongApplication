package com.example.feature_user_data

import com.example.core_database.ShopDao
import com.example.feature_user_data.mapper.toUserDB
import com.example.feature_user_data.mapper.toUserModel
import com.example.feature_user_data.model.UserModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val shopDao: ShopDao
): UserRepository {
    override suspend fun insertUser(user: UserModel) {
        shopDao.insertUser(user.toUserDB())
    }

    override suspend fun deleteUser(user: UserModel) {
        shopDao.deleteUser(user.toUserDB())
    }

    override suspend fun getUser(email: String): UserModel? =
        shopDao.getUserByEmail(email)?.toUserModel()
}