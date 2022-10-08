package com.tienda.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tienda.model.Tienda

@Dao
interface TiendaDao {


    //Las funciones de bajo nivel para hacer un CRUD

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTienda(tienda: Tienda)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTienda(tienda: Tienda)

    @Delete
    suspend fun deleteTienda(tienda: Tienda)

    @Query("SELECT *  FROM TIENDA")
    fun getTiendas() : LiveData<List<Tienda>>
}