package com.keelim.feed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.keelim.feed.R
import com.keelim.feed.databinding.ActivityMainBinding
import com.keelim.feed.ui.feed.FeedFragment
import com.keelim.feed.ui.recommend.RecommendFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriterActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews()  = with(binding){

        viewpagerMain.apply {
            adapter = MainViewPagerAdapter(this@WriterActivity).apply {
                fragmentList.addAll(listOf(
                    FeedFragment.newInstance(),
                    RecommendFragment.newInstance(),
                    TempFragment.newInstance(),
                    TempFragment.newInstance(),
                    TempFragment.newInstance(),
                ))
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    bottomNavigationMain.menu.getItem(position).isChecked = true
                }
            })
        }

        bottomNavigationMain.setOnItemSelectedListener {
            viewpagerMain.currentItem = when(it.itemId) {
                R.id.menu_feed -> FEED_FRAGMENT
                R.id.menu_recommend -> RECOMMEND_FRAGMENT
                R.id.menu_write -> WRITE_FRAGMENT
                R.id.menu_alarm -> ALARM_FRAGMENT
                else -> PROFILE_FRAGMENT
            }
            return@setOnItemSelectedListener true
        }

        imageviewMainWrite.setOnClickListener {
            viewpagerMain.currentItem = WRITE_FRAGMENT
        }

        bottomNavigationMain.itemIconTintList = null
    }

    private companion object {
        const val FEED_FRAGMENT = 0
        const val RECOMMEND_FRAGMENT = 1
        const val WRITE_FRAGMENT = 2
        const val ALARM_FRAGMENT = 3
        const val PROFILE_FRAGMENT = 4
    }
}