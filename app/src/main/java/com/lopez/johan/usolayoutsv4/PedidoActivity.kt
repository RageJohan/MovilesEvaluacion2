package com.lopez.johan.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PedidoActivity : AppCompatActivity() {

    private lateinit var tvNombreCliente: TextView
    private lateinit var tvNumeroCliente: TextView
    private lateinit var tvProductos: TextView
    private lateinit var tvUbicacion: TextView
    private lateinit var btnLlamar: ImageView
    private lateinit var btnWhatsapp: ImageView
    private lateinit var btnMaps: ImageView

    private var nombreCliente: String = ""
    private var numeroCliente: String = ""
    private var productos: String = ""
    private var ciudad: String = ""
    private var direccion: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        tvNombreCliente = findViewById(R.id.tvNombreCliente)
        tvNumeroCliente = findViewById(R.id.tvNumeroCliente)
        tvProductos = findViewById(R.id.tvProductos)
        tvUbicacion = findViewById(R.id.tvUbicacion)
        btnLlamar = findViewById(R.id.btnLlamar)
        btnWhatsapp = findViewById(R.id.btnWhatsapp)
        btnMaps = findViewById(R.id.btnMaps)

        intent.extras?.let { bundle ->
            nombreCliente = bundle.getString("NOMBRE_CLIENTE", "")
            numeroCliente = bundle.getString("NUMERO_CLIENTE", "")
            productos = bundle.getString("PRODUCTOS", "")
            ciudad = bundle.getString("CIUDAD", "")
            direccion = bundle.getString("DIRECCION", "")

            tvNombreCliente.text = nombreCliente
            tvNumeroCliente.text = numeroCliente
            tvProductos.text = productos
            tvUbicacion.text = "$ciudad, $direccion"
        }

        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intent)
        }

        btnWhatsapp.setOnClickListener {
            val message = "Hola $nombreCliente Tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroCliente&text=${Uri.encode(message)}")
            }
            startActivity(intent)
        }

        btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$direccion")
            }
            startActivity(intent)
        }
    }
}