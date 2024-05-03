package com.example.loveapi.ui.fragments.loveCalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapi.data.model.LoveModel
import com.example.loveapi.data.repository.LoveRepository

class LoveViewModel : ViewModel() {

    private val repository = LoveRepository()
    val error: LiveData<String> = repository.error
    val flag: LiveData<Boolean> = repository.flag
    fun getLovePercentage(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLovePercentage(firstName, secondName)
    }

}