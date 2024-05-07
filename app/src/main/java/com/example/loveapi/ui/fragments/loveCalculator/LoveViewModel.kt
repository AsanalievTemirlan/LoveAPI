package com.example.loveapi.ui.fragments.loveCalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapi.data.local.dao.LoveDao
import com.example.loveapi.data.network.model.LoveModel
import com.example.loveapi.data.repository.LoveRepository
import com.example.loveapi.`interface`.LoveApiService
import javax.inject.Inject

class LoveViewModel : ViewModel() {

    private val repository = LoveRepository()
    val error: LiveData<String> = repository.error
    val flag: LiveData<Boolean> = repository.flag
    fun getLovePercentage(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLovePercentage(firstName, secondName)
    }

}