package com.technical.cats.di

import com.technical.data.repository.CatsRepository
import com.technical.data.source.LocalDataSource
import com.technical.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun catRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    )=CatsRepository(localDataSource,remoteDataSource)
}