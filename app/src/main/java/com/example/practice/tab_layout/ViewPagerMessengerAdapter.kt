package com.example.practice.tab_layout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerMessengerAdapter(fm:FragmentActivity) : FragmentStateAdapter(fm) {
    private val tabTitles = arrayOf("Chats", "Status", "Calls")

    override fun getItemCount(): Int {
        return tabTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0-> ChatFragment()
            1-> StatusFragment()
            2-> CallFragment()
            else -> ChatFragment()
        }
    }

    fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }



}