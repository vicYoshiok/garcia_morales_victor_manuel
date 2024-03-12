package com.example.scannerqr

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.scannerqr.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        binding.buttonScanner.setOnClickListener {initScaner() }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var result = IntentIntegrator.parseActivityResult(resultCode, data)

        if (result != null){
            if (result.contents == null){

                Toast.makeText(this, "CAncelado", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,  "El contenido es ${result.contents}", Toast.LENGTH_SHORT).show()
                binding.textView1.text = "El contenido es ${result.contents}"

            }

        } else{
            super.onActivityReenter(resultCode, data)
        }
    }


    private fun initScaner() {
        IntentIntegrator(this).initiateScan()
    }

}