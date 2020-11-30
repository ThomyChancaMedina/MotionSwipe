package com.technical.cats.ui.main

import com.technical.data.repository.CatsRepository
import com.technical.usecases.GetCats
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class MainFragmentModule{

    @Provides
    fun mainViewModelProvider(getCats: GetCats)=MainViewModel(getCats)

    @Provides
    fun getCatsProvider(catsRepository: CatsRepository)=
        GetCats(catsRepository)
}
@Subcomponent(modules = [(MainFragmentModule::class)])
interface MainFragmentComponent{
    val mainViewModel:MainViewModel
}