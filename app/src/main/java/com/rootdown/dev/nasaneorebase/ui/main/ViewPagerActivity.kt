package com.rootdown.dev.nasaneorebase.ui.main


import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayoutMediator
import com.rootdown.dev.nasaneorebase.R
import com.rootdown.dev.nasaneorebase.databinding.ActivityViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerActivity : AppCompatActivity() {
    val tabs = arrayOf("Neo", "Media")
    private lateinit var drawableTab1: Drawable
    private lateinit var drawableTab2: Drawable
    private lateinit var toolbar: MaterialToolbar
    private val lsTabs: MutableList<Drawable> = mutableListOf()
    private val vm: PageViewModel by viewModels()
    private lateinit var binding: ActivityViewPagerBinding
    private lateinit var viewPager: ViewPager2

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        toolbar = binding.toolbar
        viewPager = binding.viewPager
        setSupportActionBar(toolbar)
        drawableTab1 = applicationContext.getDrawable(R.drawable.ic_baseline_stars_24)!!
        drawableTab2 = applicationContext.getDrawable(R.drawable.ic_baseline_perm_media_24)!!
        lsTabs.add(drawableTab1)
        lsTabs.add(drawableTab2)
        val tabLayout = binding.tabLayout
        val adapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabs[position]
            tab.icon = lsTabs[position]
        }.attach()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_light-> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }
        R.id.action_dark -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}