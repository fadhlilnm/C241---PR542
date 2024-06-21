package com.dicoding.inwarkop

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.inwarkop.adapter.WarkopAdapter
import com.dicoding.inwarkop.response.WarkopResponse
import com.dicoding.inwarkop.viewmodel.WarkopViewModel

class WarkopListActivity : AppCompatActivity() {

    private lateinit var adapter: WarkopAdapter
    private lateinit var apiUrl: String
    private lateinit var region: String
    private lateinit var progressBar: ProgressBar
    private val viewModel: WarkopViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warkop_list)

        // Get API URL and Region from intent
        apiUrl = intent.getStringExtra("API_URL") ?: ""
        region = intent.getStringExtra("EXTRA_REGION") ?: ""

        // Set region text
        val regionTextView: TextView = findViewById(R.id.regionTextView)
        regionTextView.text = region

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WarkopAdapter()
        recyclerView.adapter = adapter

        // Set up ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // Observe ViewModel data
        viewModel.warkopList.observe(this, Observer { warkopList ->
            adapter.submitList(warkopList)
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        // Fetch restaurant data
        viewModel.fetchWarkopData(apiUrl)
    }
}
