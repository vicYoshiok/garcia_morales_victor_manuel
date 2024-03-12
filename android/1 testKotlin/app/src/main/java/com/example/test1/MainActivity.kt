package com.example.test1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test1.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        binding.button1.setOnClickListener{
            //al ejecutar la app no habra respuesta en la pantalla unicamente en la consola
            //esta prueba la realice con los ejemplos  de arreglo que venian en el test
            //llamamos la función que realizará la prueba, puedes cambiar el arreglo acorde a las preubas que necesites
            val inputArray = arrayOf("aba", "aa", "ad", "vcd", "aba")
            val stringMasLargo = StringMasGrande(inputArray)
            println("resultado de la prueba: ")
            println(stringMasLargo.joinToString())

        }
    }

    fun StringMasGrande(inputArray: Array<String>): Array<String> {
        //validamos las condiciones de longitud de los arreglos  que no este vacio y que no sea mayor a 10 la longitud
        if (inputArray.isEmpty()) {
            println("Arreglo vacío")
            return emptyArray()
        }

        if (inputArray.size > 10) {
            println("Longitud del arreglo no válida")
            return emptyArray()
        }
        //buscamos el elemento de mayor longitud y lo tomamos como referencia para compararlos con la longitud de cada elemento
        // si es igual se agrega al array de retorno
        val mayorLongitud = inputArray.maxByOrNull { it.length }?.length ?: 0
        return inputArray.filter { it.length == mayorLongitud }.toTypedArray()
    }

}