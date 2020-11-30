package com.technical.cats.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cat::class], version = 1)
abstract class CatDatabase : RoomDatabase() {

    abstract fun catDao(): CatDao
}