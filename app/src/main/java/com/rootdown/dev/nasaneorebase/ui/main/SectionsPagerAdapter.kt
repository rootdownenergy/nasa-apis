package com.rootdown.dev.nasaneorebase.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rootdown.dev.nasaneorebase.ui.feature_creator.CreatorFragment
import com.rootdown.dev.nasaneorebase.ui.feature_nasa_media.MediaFragment
import com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo.NeoFragment


private const val NUM_TABS = 3

class SectionsPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle)  {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return NeoFragment()
            1 -> return MediaFragment()
        }
        return CreatorFragment()
    }

}