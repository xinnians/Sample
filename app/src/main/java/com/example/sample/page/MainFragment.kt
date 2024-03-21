package com.example.sample.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.sample.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainFragment : Fragment() {
    private var viewPager: ViewPager2? = null
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_main, container, false)

        // 初始化ViewPager
        viewPager = rootView.findViewById<ViewPager2>(R.id.viewPager).apply {
            setAdapter(ViewPagerAdapter(requireActivity()))
        }

        // 初始化BottomNavigationView
        bottomNavigationView =
            rootView.findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        bottomNavigationView?.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menu_item_1 -> {
                        viewPager?.setCurrentItem(0, false)
                        return true
                    }

                    R.id.menu_item_2 -> {
                        viewPager?.setCurrentItem(1, false)
                        return true
                    }

                    R.id.menu_item_3 -> {
                        viewPager?.setCurrentItem(2, false)
                        return true
                    }

                    R.id.menu_item_4 -> {
                        viewPager?.setCurrentItem(3, false)
                        return true
                    }
                }
                return false
            }
        })


        // ViewPager页面切换监听，同步更新BottomNavigationView的选中状态
        viewPager?.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView?.menu?.getItem(position)?.setChecked(true)
            }
        })
        return rootView
    }

    // ViewPager适配器
    private class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ChatListFragment()
                1 -> AddressListFragment()
                2 -> VoiceChatListFragment()
                3 -> MyFragment()
                else -> MyFragment()
            }
        }

        override fun getItemCount(): Int {
            return NUM_PAGES
        }

        companion object {
            private const val NUM_PAGES = 4 // ViewPager中总共有四个Fragment
        }
    }
}

