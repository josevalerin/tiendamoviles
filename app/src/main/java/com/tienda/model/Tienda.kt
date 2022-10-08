package com.tienda.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="tienda")
data class Tienda(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="nombre")
    val nombre:String,
    @ColumnInfo(name="modelo")
    val modelo:String?,
    @ColumnInfo(name="precio")
    val precio:String,
    @ColumnInfo(name="latitud")
    val latitud: Double?,
    @ColumnInfo(name="longitud")
    val longitud: Double?,
    @ColumnInfo(name="altura")
    val altura: Double?,
    @ColumnInfo(name="ruta_audio")
    val rutaAudio: String,
    @ColumnInfo(name="ruta_imagen")
    val rutaImagen: String
) : Parcelable
