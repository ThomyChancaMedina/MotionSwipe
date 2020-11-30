package com.technical.cats.data.database

import com.technical.cats.App
import com.technical.cats.data.toDomainCat
import com.technical.cats.data.toRoomCat
import com.technical.data.source.LocalDataSource
import com.technical.domain.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: CatDatabase) : LocalDataSource {
    private val catDao = db.catDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { catDao.catCount() <= 0 }


    override suspend fun saveCats(cats: List<Cat>) {
        withContext(Dispatchers.IO) { catDao.insertCat(cats.map { it.toRoomCat() }) }
    }

    override suspend fun getCats(): List<Cat> =
        withContext(Dispatchers.IO) {
            catDao.getAll().map { it.toDomainCat() }
        }

    override suspend fun findCatForCountry(country: String): List<Cat> = withContext(Dispatchers.IO){
        catDao.findByCountry(country).map { it.toDomainCat() }
    }

    override suspend fun findById(id: Int): Cat = withContext(Dispatchers.IO){
        catDao.findById(id).toDomainCat()
    }

    override suspend fun update(cat: Cat) {
        withContext(Dispatchers.IO){catDao.updateCat(cat.toRoomCat())}
    }

}