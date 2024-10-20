package com.lopez.johan.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegistroPedidosActivity : AppCompatActivity() {

    private lateinit var etNombreCliente: TextInputEditText
    private lateinit var etNumeroCliente: TextInputEditText
    private lateinit var etProductos: TextInputEditText
    private lateinit var etCiudad: TextInputEditText
    private lateinit var etDireccion: TextInputEditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pedidos)

        etNombreCliente = findViewById(R.id.etNombreCliente)
        etNumeroCliente = findViewById(R.id.etNumeroCliente)
        etProductos = findViewById(R.id.etProductos)
        etCiudad = findViewById(R.id.etCiudad)
        etDireccion = findViewById(R.id.etDireccion)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            if (validateInputs()) {
                val intent = Intent(this, PedidoActivity::class.java).apply {
                    putExtra("NOMBRE_CLIENTE", etNombreCliente.text.toString())
                    putExtra("NUMERO_CLIENTE", etNumeroCliente.text.toString())
                    putExtra("PRODUCTOS", etProductos.text.toString())
                    putExtra("CIUDAD", etCiudad.text.toString())
                    putExtra("DIRECCION", etDireccion.text.toString())
                }
                startActivity(intent)
            }
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        if (etNombreCliente.text.isNullOrBlank()) {
            etNombreCliente.error = "Campo requerido"
            isValid = false
        }
        if (etNumeroCliente.text.isNullOrBlank()) {
            etNumeroCliente.error = "Campo requerido"
            isValid = false
        }
        if (etProductos.text.isNullOrBlank()) {
            etProductos.error = "Campo requerido"
            isValid = false
        }
        if (etCiudad.text.isNullOrBlank()) {
            etCiudad.error = "Campo requerido"
            isValid = false
        }
        if (etDireccion.text.isNullOrBlank()) {
            etDireccion.error = "Campo requerido"
            isValid = false
        }

        if (!isValid) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }

        return isValid
    }
}