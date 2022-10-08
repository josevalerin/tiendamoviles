package com.tienda.ui.tienda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tienda.R
import com.tienda.databinding.FragmentTiendaBinding
import com.tienda.viewmodel.TiendaViewModel

class TiendaFragment : Fragment() {

    private var _binding: FragmentTiendaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tiendaViewModel =
            ViewModelProvider(this).get(TiendaViewModel::class.java)

        _binding = FragmentTiendaBinding.inflate(inflater, container, false)

        binding.addLugarButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_tienda_to_addTiendaFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}