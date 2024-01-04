package com.example.core_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core_database.model.UserDB

@Database(
    entities = [
        UserDB::class
    ], version = 1, exportSchema = false
)
internal abstract class ShopDatabase : RoomDatabase() {

    abstract fun shopDao(): ShopDao

    companion object {
        private const val SHOP_DB_NAME = "shop_db"
        fun getInstance(context: Context): ShopDao =
            Room.databaseBuilder(context, ShopDatabase::class.java, SHOP_DB_NAME)
                .build()
                .shopDao()
    }
}