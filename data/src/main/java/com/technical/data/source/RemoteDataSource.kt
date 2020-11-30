package com.technical.data.source

import com.technical.domain.Cat

interface RemoteDataSource {
    suspend fun getCats():List<Cat>
}