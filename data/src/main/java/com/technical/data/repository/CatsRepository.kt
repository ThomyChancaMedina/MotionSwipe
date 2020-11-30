package com.technical.data.repository

import com.technical.data.source.LocalDataSource
import com.technical.data.source.RemoteDataSource
import com.technical.domain.Cat

class CatsRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getCats(): List<Cat> {
        if (localDataSource.isEmpty()) {
            val cats = remoteDataSource.getCats()

            localDataSource.saveCats(cats)
        }
        return localDataSource.getCats()
    }

    suspend fun findForCountry(country: String): List<Cat> =
        localDataSource.findCatForCountry(country)

    suspend fun update(cat: Cat) = localDataSource.update(cat)
}