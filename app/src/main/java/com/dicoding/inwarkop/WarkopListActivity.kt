package com.dicoding.inwarkop

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.inwarkop.adapter.WarkopAdapter
import com.dicoding.inwarkop.response.WarkopResponse
import com.dicoding.restaurantreview.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WarkopListActivity : AppCompatActivity() {

    private lateinit var adapter: WarkopAdapter
    private val warkopList = mutableListOf<WarkopResponse>()
    private lateinit var apiUrl: String
    private lateinit var region: String // tambahkan ini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warkop_list)

        // Get API URL and Region from intent
        apiUrl = intent.getStringExtra("API_URL") ?: ""
        region = intent.getStringExtra("EXTRA_REGION") ?: ""

        // Set region text
        val regionTextView: TextView = findViewById(R.id.regionTextView)
        regionTextView.text = region // Set text to the region name

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WarkopAdapter(warkopList)
        recyclerView.adapter = adapter

        // Fetch restaurant data
        fetchWarkopData()
    }

    private fun fetchWarkopData() {
        ApiConfig.getApiService().getWarkopList(apiUrl).enqueue(object : Callback<List<WarkopResponse>> {
            override fun onResponse(call: Call<List<WarkopResponse>>, response: Response<List<WarkopResponse>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        warkopList.clear()
                        warkopList.addAll(it)
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<WarkopResponse>>, t: Throwable) {
                Log.e("RestaurantListActivity", "onFailure: ", t)
            }
        })
    }
}
