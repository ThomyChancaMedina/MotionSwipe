package com.technical.cats.di

import android.app.Application
import com.technical.cats.ui.card.CardActivityComponent
import com.technical.cats.ui.card.CardActivityModule
import com.technical.cats.ui.main.MainFragmentComponent
import com.technical.cats.ui.main.MainFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class,DataModule::class])
interface CatsComponent {

    fun plus(module:MainFragmentModule):MainFragmentComponent
    fun plus(module: CardActivityModule):CardActivityComponent

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app:Application):CatsComponent
    }

}