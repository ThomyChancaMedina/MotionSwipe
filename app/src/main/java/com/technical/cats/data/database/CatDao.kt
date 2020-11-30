package com.technical.cats.data.database

import androidx.room.*

@Dao
interface CatDao {

    @Query("SELECT * FROM Cat")
    fun getAll(): List<Cat>

    @Query("SELECT * FROM Cat WHERE id = :id")
    fun findById(id: Int): Cat


    @Query("SELECT * FROM Cat WHERE country = :country")
    fun findByCountry(country: String): List<Cat>

    @Query("SELECT COUNT(id) FROM Cat")
    fun catCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCat(cat: List<Cat>)

    @Update
    fun updateCat(cat: Cat)
}