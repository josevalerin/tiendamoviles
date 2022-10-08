package com.tienda.repository

import androidx.lifecycle.LiveData
import com.tienda.data.TiendaDao
import com.tienda.model.Tienda

class TiendaRepository (private val tiendaDao: TiendaDao){

    suspend fun saveTienda(tienda: Tienda){

        if(tienda.id==0){

            //Es un lugar nuevo...
            tiendaDao.addTienda(tienda)
        }else {
            tiendaDao.addTienda(tienda)
        }
    }suspend fun deleteTienda(tienda: Tienda){

        if(tienda.id==0) {

            //si el id tiene un valor lo intento eliminar
            tiendaDao.deleteTienda(tienda)
        }
    }
    val getTiendas : LiveData<List<Tienda>> = tiendaDao.getTiendas()

}