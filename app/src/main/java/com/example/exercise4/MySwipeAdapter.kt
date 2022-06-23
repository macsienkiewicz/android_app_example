package com.example.exercise4

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MySwipeAdapter(fg: Fragment): FragmentStateAdapter(fg) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return Fragment32.newInstance(position)
    }
}