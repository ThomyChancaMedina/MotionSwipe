package com.technical.cats.ui.card

import com.technical.data.repository.CatsRepository
import com.technical.usecases.FindCatByCountry
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CardActivityModule(private val country: String) {
    @Provides
    fun cardViewModelProvider(
        findCatByCountry: FindCatByCountry
    ):CardViewModel{
        return CardViewModel(country,findCatByCountry)
    }

    @Provides
    fun findCatsByCountryProvider(catsRepository: CatsRepository)=FindCatByCountry(catsRepository)



}

@Subcomponent(modules = [(CardActivityModule::class)])
interface CardActivityComponent{
    val cardViewModel:CardViewModel
}

