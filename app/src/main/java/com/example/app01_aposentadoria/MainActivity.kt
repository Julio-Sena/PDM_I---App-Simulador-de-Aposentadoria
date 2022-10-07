package com.example.app01_aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Gênero)
        val txt_Idade = findViewById<TextView>(R.id.txt_Idade)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val txt_Contribuicao = findViewById<TextView>(R.id.txt_Contribuição)

        spn_Sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino","Feminino"))

        //btn_Calcular_onclick
        btn_Calcular.setOnClickListener{
            val sexo = spn_Sexo.selectedItem as String
            val idade = txt_Idade.text.toString().toInt()
            var resultado = 0
            if(sexo == "Masculino"){
                resultado = 65 - idade
            } else{
                resultado = 60 - idade
            }
            txt_Resultado.text = "Faltam $resultado anos para sua aposentadoria, conforme a nova Previdência 2022."

        }
    }
}