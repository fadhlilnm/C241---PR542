package com.dicoding.inwarkop.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.inwarkop.FrontActivity
import com.dicoding.inwarkop.R
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 4000 // 4 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Penundaan untuk splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            // Mulai Aktivitas Utama setelah penundaan
            val intent = Intent(this, FrontActivity::class.java)
            startActivity(intent)
            finish() // Selesaikan aktivitas splash agar dihapus dari stack belakang
        }, splashTimeOut)
    }
}
