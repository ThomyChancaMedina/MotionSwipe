package com.technical.cats.di

import android.app.Application
import androidx.room.Room
import com.technical.cats.data.database.CatDatabase
import com.technical.cats.data.database.RoomDataSource
import com.technical.cats.data.server.CatDbDataSource
import com.technical.data.source.LocalDataSource
import com.technical.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        CatDatabase::class.java,
        "cat-db"

    ).build()

    @Provides
    fun localDataSourceProvide(db:CatDatabase): LocalDataSource=RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider():RemoteDataSource=CatDbDataSource()


}