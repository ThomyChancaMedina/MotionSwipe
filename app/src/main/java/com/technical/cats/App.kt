package com.technical.cats

import android.app.Application
import androidx.room.Room
import com.technical.cats.data.database.CatDatabase
import com.technical.cats.di.CatsComponent
import com.technical.cats.di.DaggerCatsComponent


class App : Application() {

    lateinit var component: CatsComponent
    private set

    lateinit var db: CatDatabase
        private set
    override fun onCreate() {
        super.onCreate()

        component = DaggerCatsComponent
            .factory()
            .create(this)
    }



}