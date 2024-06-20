package com.dicoding.inwarkop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.inwarkop.databinding.ActivityFrontBinding

class FrontActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFrontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEnter.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}