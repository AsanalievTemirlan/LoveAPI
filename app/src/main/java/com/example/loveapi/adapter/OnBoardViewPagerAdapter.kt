package com.example.loveapi.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.loveapi.ui.fragments.viewPager.ViewPagerPagingFragment
import com.example.loveapi.ui.fragments.viewPager.ViewPagerPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = ViewPagerPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}