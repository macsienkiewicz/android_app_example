package com.example.exercise4

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class MyPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {
    private val PAGE_COUNT = 3

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> Fragment21.newInstance("f21", "Page #1")
            1 -> Fragment22.newInstance("f22", "Page #2")
            else -> Fragment23.newInstance("f23", "Page #3")
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Fragment21"
            1 -> "Fragment22"
            else -> "Fragment23"
        }
    }
}