package com.technical.cats.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.technical.cats.ui.common.Event
import com.technical.cats.ui.common.Scope
import com.technical.cats.ui.common.ScopedViewModel
import com.technical.domain.Cat
import com.technical.usecases.GetCats
import kotlinx.coroutines.launch

class MainViewModel(private val getCats: GetCats ) : ScopedViewModel() {

    val TAG=MainViewModel::class.java.simpleName


    private val _cat = MutableLiveData<List<Cat>>()
    val cat: LiveData<List<Cat>> get() = _cat



    private val _model = MutableLiveData<Event<Unit>>()
    val model: LiveData<Event<Unit>> get() = _model

    init {
        initScope()
        refresh()
    }

    private fun refresh() {
        _model.value = Event(Unit)
    }

    fun getAllCats() {
        launch {

            _cat.value = getCats.invoke()

        }
    }



    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}
