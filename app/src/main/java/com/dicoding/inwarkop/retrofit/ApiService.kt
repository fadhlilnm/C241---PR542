package com.dicoding.restaurantreview.data.retrofit

import com.dicoding.inwarkop.response.WarkopResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getWarkopList(@Url url: String): Call<List<WarkopResponse>>
}