package com.example.loveapi.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.loveapi.data.model.LoveModel
import com.example.loveapi.`object`.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveRepository {

    private val api = RetrofitService.api
    private var lovePercentageLv = MutableLiveData<LoveModel>()

    fun getLovePercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        api.getPercentage(
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {
                    lovePercentageLv.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("fail", "onFailure: $t.error")
            }

        })
        return lovePercentageLv
    }


}