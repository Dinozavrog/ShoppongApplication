package com.example.core_database

import android.content.Context
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.model.UserDB

@Dao
interface ShopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(entity: UserDB)

    @Delete
    suspend fun deleteUser(entity: UserDB)

    @Query("SELECT * FROM ${UserDB.TABLE_NAME} WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserDB?
}

fun getShopDao(context: Context): ShopDao =
    ShopDatabase.getInstance(context)