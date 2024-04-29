package com.example.loveapi.`interface`

import com.example.loveapi.data.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {
    @GET("getPercentage")
    fun getPercentage(
        @Header("X-RapidAPI-Key") apiKey: String = "7da892be13msha2289d8c44d7d25p170135jsn9d904df92c73",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
    ): Call<LoveModel>



}