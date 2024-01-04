package com.example.feature_user_data.mapper

import com.example.core_database.model.UserDB
import com.example.feature_user_data.model.UserModel

fun UserDB.toUserModel(): UserModel {
    return UserModel(
        email = this.email,
        password = this.password,
        name = this.username
    )
}

fun UserModel.toUserDB(): UserDB{
    return UserDB(
        email = this.email,
        password = this.password,
        username = this.name
    )
}