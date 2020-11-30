package com.technical.data.source

import com.technical.domain.Cat

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveCats(cats: List<Cat>)
    suspend fun getCats(): List<Cat>
    suspend fun findCatForCountry(country:String):List<Cat>
    suspend fun findById(id: Int): Cat
    suspend fun update(cat: Cat)
}