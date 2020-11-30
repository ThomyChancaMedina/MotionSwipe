package com.technical.usecases

import com.technical.data.repository.CatsRepository
import com.technical.domain.Cat

class FindCatByCountry(private val catsRepository: CatsRepository) {
    suspend fun invoke(country:String): List<Cat> = catsRepository.findForCountry(country)
}