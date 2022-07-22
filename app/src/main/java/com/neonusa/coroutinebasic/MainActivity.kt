package com.neonusa.coroutinebasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.neonusa.coroutinebasic.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvStartCoroutine.setOnClickListener {
            coroutineFunc()
        }

        binding.btnTest.setOnClickListener {
            if(binding.tvTest.text == "on"){
                binding.tvTest.text = "off"
                Log.i("MainActivity", "onCreate: turned off")
            } else {
                binding.tvTest.text = "on"
                Log.i("MainActivity", "onCreate: turned on")
            }
        }

    }

    // membuat sebuah coroutine function dasar
    // launch digunakan untuk membuat sebuah coroutine baru yang berjalan pada thread main
    // (lihat penggunaan dispatchers.main)

    private fun coroutineFunc() = CoroutineScope(Dispatchers.Main).launch {
        for (i in 1..100) {
            Log.i("MainActivity", "coroutineFunc: $i")
            delay(1000)
            binding.tvPercent.text = i.toString()
        }
    }
}