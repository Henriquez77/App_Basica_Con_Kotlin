package com.example.clinica

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var tvNombre = findViewById<TextView>(R.id.tvNombre)
        var tvApellido = findViewById<TextView>(R.id.tvApellido)
        var tvEdad = findViewById<TextView>(R.id.tvEdad)
        var tvDepartamento = findViewById<TextView>(R.id.tvDepartamento)
        var tvTelefono = findViewById<TextView>(R.id.tvTelefono)
        var tvCondicion = findViewById<TextView>(R.id.tvCondicion)
        var bRegresar = findViewById<Button>(R.id.bRegresar)
        val datos: SharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        tvNombre.text = datos.getString("nombre", null)
        tvApellido.text = datos.getString("apellido", null)
        tvEdad.text = datos.getString("edad", null)
        tvDepartamento.text = datos.getString("departamento", null)
        tvTelefono.text = datos.getString("telefono", null)
        tvCondicion.text = datos.getString("condicion", null)

        bRegresar.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}