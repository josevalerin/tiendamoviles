package com.tienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tienda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    Definicion del objeto para hacer la autenticacion
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        // Crear metodo de login

        binding.btLogin.setOnClickListener {
            haceLogin();
        }

        binding.btRegister.setOnClickListener {
            haceRegister();
        }

    }

    private fun haceRegister() {
        //guardamos la inforacion registrada
        val email = binding.etEmail.text.trim().toString()
        val clave = binding.etClave.text.trim().toString()

        //se llama a la funcion para crear un usuario en la base de datos
        auth.createUserWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                var user: FirebaseUser? = null
                if (task.isSuccessful) { // si pudo crear al usuario
                    Log.d("Creando usuario", "Registrado")
                    user = auth.currentUser // si pudo recuperar la info del usuario
                    actualiza(user)
                } else {
                    Log.d("Creando usuario", "Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()

        auth.signInWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                var user: FirebaseUser? = null
                if (task.isSuccessful) {
                    Log.d("Autenticando", "Auntenticado")
                    user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Autenticando", "Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_SHORT).show()
                }
                    actualiza(null)
                }
            }
        private fun actualiza(user :FirebaseUser?) {
            // si hay un usuario definido se pasa a la pantalla principal
            if(user != null){
                //pasa a la otra pantalla
                val intent = Intent(this, Principal::class.java)
                startActivity(intent)
            }
        }
    //    Esto hara que una vez autenticado no nos vuelva a pedir las credenciales
//    a menos que se haya cerrado la sesion
    public override fun onStart(){
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }
    }
