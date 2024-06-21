package com.dicoding.inwarkop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.inwarkop.response.WarkopResponse
import com.dicoding.restaurantreview.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WarkopViewModel : ViewModel() {

    private val _warkopList = MutableLiveData<List<WarkopResponse>>()
    val warkopList: LiveData<List<WarkopResponse>> = _warkopList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchWarkopData(apiUrl: String) {
        _isLoading.value = true
        ApiConfig.getApiService().getWarkopList(apiUrl).enqueue(object : Callback<List<WarkopResponse>> {
            override fun onResponse(call: Call<List<WarkopResponse>>, response: Response<List<WarkopResponse>>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _warkopList.value = response.body()
                } else {
                    _warkopList.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<WarkopResponse>>, t: Throwable) {
                _isLoading.value = false
                _warkopList.value = emptyList()
            }
        })
    }
}
