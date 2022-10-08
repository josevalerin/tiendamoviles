package com.tienda.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TiendaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is tienda Fragment"
    }
    val text: LiveData<String> = _text
}