package com.example.loveapi.ui.fragments.loveCalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loveapi.R
import com.example.loveapi.adapter.HistoryAdapter
import com.example.loveapi.databinding.FragmentHistoryBinding
import com.example.loveapi.di.AppModule
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var adapter: HistoryAdapter
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HistoryAdapter()
        val list = AppModule().provideRoomDataBase(requireContext()).getHistoryDao().getHistory()
        binding.rvHistory.adapter = adapter
        adapter.submitList(list)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnBack.setOnClickListener {
            findNavController().navigate(R.id.loveCalculatorFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    private fun updateList() {
        val historyList = AppModule().provideRoomDataBase(requireContext()).getHistoryDao().getHistory()
        adapter.submitList(historyList)
    }
}