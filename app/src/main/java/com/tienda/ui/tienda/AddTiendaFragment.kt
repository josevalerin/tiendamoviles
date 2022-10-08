package com.tienda.ui.tienda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tienda.R
import com.tienda.databinding.FragmentAddTiendaBinding
import com.tienda.model.Tienda
import com.tienda.viewmodel.TiendaViewModel

class AddTiendaFragment : Fragment() {

    private lateinit var tiendaViewModel: TiendaViewModel
    private var _binding: FragmentAddTiendaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         tiendaViewModel =
            ViewModelProvider(this).get(TiendaViewModel::class.java)

        _binding = FragmentAddTiendaBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener{addTienda() }

        return binding.root
    }

    private fun addTienda() {
        val nombre = binding.etNombre.text.toString() //obtiene el texto del nombre
        if (nombre.isNotEmpty()) {//si se escribio algo en el texto guardalo

            val modelo = binding.etModelo.text.toString() //obtiene el texto del nombre
            val precio = binding.etPrecio.text.toString() //obtiene el texto del nombre

            val tienda = Tienda(0, nombre, modelo, precio, 0.0, 0.0, 0.0, "","")

            //se procede a registrar el nuevo lugar...
            tiendaViewModel.saveTienda(tienda)
            Toast.makeText(requireContext(),
                getString(R.string.msg_lugar_added),
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addTiendaFragment_to_nav_tienda)
        } else { //no se puede registrar el lugar... falta info
            Toast.makeText(requireContext(),
                getString(R.string.msg_data),
                Toast.LENGTH_LONG ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}