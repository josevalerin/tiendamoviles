package com.tienda.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.tienda.data.TiendaDatabase
import com.tienda.model.Tienda
import com.tienda.repository.TiendaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TiendaViewModel (application: Application) : AndroidViewModel(application) {

    private val tiendaRepository: TiendaRepository
    val getTiendas: LiveData<List<Tienda>>

    init {

        val tiendaDao = TiendaDatabase.getDatabase(application).tiendaDao()
        tiendaRepository = TiendaRepository(tiendaDao)
        getTiendas = tiendaRepository.getTiendas
    }
    fun saveTienda(tienda: Tienda){
        viewModelScope.launch(Dispatchers.IO) {
            tiendaRepository.saveTienda(tienda) }
    }
    fun deleteTienda(tienda: Tienda){
        viewModelScope.launch(Dispatchers.IO) {
            tiendaRepository.deleteTienda(tienda) }
    }


}