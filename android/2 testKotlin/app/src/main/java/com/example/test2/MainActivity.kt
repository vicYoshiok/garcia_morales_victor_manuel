package com.example.test2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        //para esta app utilice una función que se ejcuta al tocar le boton e imprime unicamente en consola el resultado del cambio de elemetos
        //el arreglo "inputArray" puede ser modificado segun las necesidades de la prueba
        binding.btn1.setOnClickListener{
            //ejecutamos la prueba definiendo el array y haciendo los filtros correspndientes
            val inputArray = arrayOf(1, 2, 1)
            val elemToReplace = 1
            val substitutionElem = 3
            if(inputArray.size >= 1){

                if(inputArray.size <= 10000){
                    if(elemToReplace >= 0){
                        if(elemToReplace <= 10000){

                            if(substitutionElem >=0){
                                if(substitutionElem <= 10000){

                                    val result = arrayReplace(inputArray, elemToReplace, substitutionElem)
                                    println("el arreglo reemplazado es: ")
                                    println(result.joinToString())
                                }
                            }

                        }

                    }
                }
            }

        }

    }

    fun arrayReplace(inputArray: Array<Int>, elemToReplace: Int, substitutionElem: Int): Array<Int> {
        // Creamos una lista para guardar los elementos modificados
        val resultList = mutableListOf<Int>()

        for (element in inputArray) {
            // Si el elemento es igual al elemento a reemplazar, lo reemplazamos con el elemento de sustitución
            if (element == elemToReplace) {
                resultList.add(substitutionElem)
            } else {
                // Si no mantenemos el elemento original
                resultList.add(element)
            }
        }

        // Convertimos la lista en array y lo devolvemos
        return resultList.toTypedArray()
    }

}