package com.tienda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tienda.databinding.TiendaFilaBinding
import com.tienda.model.Tienda

class TiendaAdapter : RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder>() {

    //clase interna que se encarga de finalmente mostrar la informacion
    inner class TiendaViewHolder(private val itemBinding: TiendaFilaBinding)
        :RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(tienda: Tienda) {
            itemBinding.tvNombre.text = tienda.nombre
            itemBinding.tvModelo.text = tienda.modelo
            itemBinding.tvPrecio.text = tienda.precio

        }

    }
    //la lista donde estan los bojetos Lugar a dibujarse...
    private var listaTiendas = emptyList<Tienda>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaViewHolder {
        val itemBinding = TiendaFilaBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        return  TiendaViewHolder(itemBinding)    }

    override fun onBindViewHolder(holder: TiendaViewHolder, position: Int) {
        val tienda = listaTiendas[position]
        holder.dibuja(tienda)    }

    override fun getItemCount(): Int {
        return listaTiendas.size
    }
    fun setListaTiendas(tiendas: List<Tienda>){
        this.listaTiendas = tiendas
        notifyDataSetChanged()
    }
}