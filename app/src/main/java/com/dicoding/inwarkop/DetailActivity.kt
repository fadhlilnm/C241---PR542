package com.dicoding.inwarkop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.inwarkop.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var adapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        binding.titleText.text = title

        // Mock data, replace with API data
        val items = listOf(
            DetailItem("https://example.com/image1.jpg", "Nama 1", "Alamat 1", "Rating 1"),
            DetailItem("https://example.com/image2.jpg", "Nama 2", "Alamat 2", "Rating 2")
        )

        adapter = DetailAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}