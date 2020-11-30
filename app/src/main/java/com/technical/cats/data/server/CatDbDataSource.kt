package com.technical.cats.data.server



import com.technical.cats.data.toDomainCat
import com.technical.data.source.RemoteDataSource
import com.technical.domain.Cat




class CatDbDataSource:RemoteDataSource {

    override suspend fun getCats(): List<Cat> =
        getCatsServer()
            .map { it.toDomainCat() }

}

