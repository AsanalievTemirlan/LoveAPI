package com.example.loveapi.ui.fragments.loveCalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.loveapi.R
import com.example.loveapi.data.model.LoveModel
import com.example.loveapi.`object`.RetrofitService
import com.example.loveapi.databinding.FragmentLoveCalculatorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnCalculate.setOnClickListener {
            RetrofitService.api.getPercentage(
                firstName = et1.text.toString(),
                secondName = et2.text.toString()
            ).enqueue(object : Callback<LoveModel> {
                @SuppressLint("SuspiciousIndentation")
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        val result = response.body()
                            setFragmentResult(
                                "key", bundleOf(
                                    "data" to result
                                )
                            )
                        findNavController().navigate(R.id.resultFragment)

                    }
                }
                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("fail", "onFailure: $t.error")
                }

            })
        }
    }
}