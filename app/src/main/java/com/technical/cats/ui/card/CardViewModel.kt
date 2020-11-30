package com.technical.cats.ui.card




import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.technical.cats.ui.common.Scope
import com.technical.cats.ui.common.ScopedViewModel
import com.technical.domain.Cat
import com.technical.usecases.FindCatByCountry
import kotlinx.coroutines.launch


class CardViewModel(private val country: String, private val findCatByCountry: FindCatByCountry) : ScopedViewModel() {


 private var topCard: Cat? =null

   private var bottomCard: Cat? =null


    val TAG = CardViewModel::class.java.simpleName

    val data:ArrayList<Cat> = ArrayList()
    private var currentIndex = 0
    private val stream = MutableLiveData<CardView>()

    val modelStream: LiveData<CardView>
        get() = stream

    private val _cat = MutableLiveData<UiModelCard>()
    val cat: LiveData<UiModelCard>
        get() {
            if (_cat.value == null) findCatsForCountry()
            return _cat
        }
//fixme cambiar por find
    fun setCats(cats: List<Cat>){
        data.addAll(cats)

    }
    sealed class UiModelCard {
        class GetAllUser(val cats: List<Cat>) : UiModelCard()

    }


    init {
        initScope()
        updateStream()
    }


    private fun findCatsForCountry() = launch {
        _cat.value = UiModelCard.GetAllUser(findCatByCountry.invoke(country))

    }


    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

    fun swipe():Boolean {
        return if (currentIndex < data.size) {
            currentIndex += 1
            updateStream()
            false
        }else{
            true
        }


    }

    private fun updateStream() {
        if (data.isNotEmpty()){
            topCard=data[currentIndex % data.size]
            bottomCard=data[(currentIndex + 1) % data.size]

            stream.value = CardView(
                top =      topCard!!,
                bottom =     bottomCard!!
            )
        }

    }

}