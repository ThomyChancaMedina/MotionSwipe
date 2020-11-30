package com.technical.usecases

import com.technical.data.repository.CatsRepository
import com.technical.domain.Cat

class GetCats (private val catsRepository: CatsRepository){
    suspend fun invoke():List<Cat> =  catsRepository.getCats()
}