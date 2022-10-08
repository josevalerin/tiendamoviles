package com.tienda.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tienda.model.Tienda


@Database(entities = [Tienda::class], version = 1, exportSchema = false)

abstract class TiendaDatabase : RoomDatabase(){

    abstract fun tiendaDao() :TiendaDao
    companion object {
        @Volatile
        private var INSTANCE: TiendaDatabase? = null

        fun getDatabase(context: Context): TiendaDatabase {

            val local = INSTANCE
            if (local != null) {
                return local
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TiendaDatabase::class.java,
                    "Tienda_Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}