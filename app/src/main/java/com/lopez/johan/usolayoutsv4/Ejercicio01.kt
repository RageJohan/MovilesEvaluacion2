package com.lopez.johan.usolayoutsv4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        val btnMostrar: Button = findViewById(R.id.btnMostrar)
        val btnOcultar: Button = findViewById(R.id.btnOcultar)
        val cardViewVerde: CardView = findViewById(R.id.cardViewVerde)

        btnMostrar.setOnClickListener {
            cardViewVerde.visibility = View.VISIBLE
        }

        btnOcultar.setOnClickListener {
            cardViewVerde.visibility = View.GONE
        }
    }
}