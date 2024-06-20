package com.dicoding.inwarkop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button click listeners
        val buttonUtara = findViewById<Button>(R.id.button_utara)
        val buttonTimur = findViewById<Button>(R.id.button_timur)
        val buttonBarat = findViewById<Button>(R.id.button_barat)
        val buttonSelatan = findViewById<Button>(R.id.button_selatan)
        val buttonTengah = findViewById<Button>(R.id.button_tengah)

        buttonUtara.setOnClickListener { openRestaurantListActivity("Utara","https://inwarkop-a6kfmr6rta-as.a.run.app/utara") }
        buttonTimur.setOnClickListener { openRestaurantListActivity("Timur","https://inwarkop-a6kfmr6rta-as.a.run.app/timur") }
        buttonBarat.setOnClickListener { openRestaurantListActivity("Barat","https://inwarkop-a6kfmr6rta-as.a.run.app/barat") }
        buttonSelatan.setOnClickListener { openRestaurantListActivity("Selatan","https://inwarkop-a6kfmr6rta-as.a.run.app/selatan") }
        buttonTengah.setOnClickListener { openRestaurantListActivity("Pusat","https://inwarkop-a6kfmr6rta-as.a.run.app/pusat") }
    }

    private fun openRestaurantListActivity(region: String, apiUrl: String) {
        val intent = Intent(this, WarkopListActivity::class.java)
        intent.putExtra("EXTRA_REGION", region)
        intent.putExtra("API_URL", apiUrl)
        startActivity(intent)
    }
}