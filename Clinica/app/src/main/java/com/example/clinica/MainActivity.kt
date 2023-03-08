package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sEdad = findViewById<Spinner>(R.id.sEdad)
        val sDepartamento = findViewById<Spinner>(R.id.sDepartamento)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val etCondicion = findViewById<EditText>(R.id.etCondicion)
        val bIngresar = findViewById<Button>(R.id.bIngresar)
        val datos:SharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        bIngresar.setOnClickListener(){
            var condicion = ""
            var nombre = ""
            var apellido = ""
            var telefono = ""
            var edad = ""
            var departamento = ""
            if(etCondicion.text.toString().isEmpty()){
                condicion = "No posee"
            }else{
                condicion = etCondicion.text.toString()
            }
            if(etNombre.text.toString().isNotEmpty() && etApellido.text.toString().isNotEmpty() && etTelefono.text.toString().isNotEmpty() && sEdad.toString().isNotEmpty() && sDepartamento.toString().isNotEmpty()){
                nombre = etNombre.text.toString()
                apellido = etApellido.text.toString()
                telefono = etTelefono.text.toString()
                edad = sEdad.selectedItem.toString()
                departamento = sDepartamento.selectedItem.toString()


                val editor:SharedPreferences.Editor = datos.edit()
                editor.putString("nombre", "$nombre")
                editor.putString("apellido","$apellido")
                editor.putString("telefono","$telefono")
                editor.putString("edad","$edad")
                editor.putString("departamento","$departamento")
                editor.putString("condicion","$condicion")
                editor.apply()

                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)



            }else{
                val toast = Toast.makeText(this, "Completar campos obligatorios", Toast.LENGTH_LONG)
                toast.show()
            }


        }

        val list = mutableListOf<String>()
        val listDepartamento = listOf<String>("Ahuchapán", "Cabañas", "Chalatenango", "Cuscatlán", "La Libertad", "La Paz", "La Unión", "Morazán", "San Miguel", "San Salvador", "Santa Ana", "San Vicente", "Sonsonate", "Usulután")
        for(i in 1..100){
            list.add(i.toString())
        }
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sEdad.adapter = adapter

        val adapterDepartamento = ArrayAdapter(this,android.R.layout.simple_spinner_item,listDepartamento)
        adapterDepartamento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sDepartamento.adapter = adapterDepartamento



    }

}