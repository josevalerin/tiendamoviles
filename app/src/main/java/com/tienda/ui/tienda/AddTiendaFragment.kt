package com.tienda.ui.tienda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.tienda.R
import com.tienda.databinding.FragmentAddTiendaBinding
import com.tienda.databinding.FragmentTiendaBinding
import com.tienda.viewmodel.TiendaViewModel

class AddTiendaFragment : Fragment() {

    private var _binding: FragmentAddTiendaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tiendaViewModel =
            ViewModelProvider(this).get(TiendaViewModel::class.java)

        _binding = FragmentAddTiendaBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}