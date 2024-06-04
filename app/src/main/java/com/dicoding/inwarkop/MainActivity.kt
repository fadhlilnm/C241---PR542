package com.dicoding.inwarkop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.inwarkop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonUtara.setOnClickListener {
            navigateToDetail("Utara")
        }

        binding.buttonTimur.setOnClickListener {
            navigateToDetail("Timur")
        }

        binding.buttonBarat.setOnClickListener {
            navigateToDetail("Barat")
        }

        binding.buttonSelatan.setOnClickListener {
            navigateToDetail("Selatan")
        }

        binding.buttonTengah.setOnClickListener {
            navigateToDetail("Tengah")
        }
    }

    private fun navigateToDetail(title: String) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("TITLE", title)
        }
        startActivity(intent)
    }
}