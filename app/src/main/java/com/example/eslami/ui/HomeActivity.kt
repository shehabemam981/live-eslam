package com.example.eslami.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.eslami.R
import com.example.eslami.databinding.ActivityHomeBinding
import com.example.eslami.ui.ahadeth.ahadethFragment
import com.example.eslami.ui.moshaf.moshafFragment
import com.example.eslami.ui.radio.radioFragment
import com.example.eslami.ui.sebha.sebhaFragment
import com.google.android.material.navigation.NavigationBarView


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        binding.content.bottomNav.selectedItemId=R.id.navRadio
    }

    private fun initView() {

        binding.content.bottomNav.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navRadio -> {
                        navigateToFragments(radioFragment())
                    }

                    R.id.navahadeth -> {
                        navigateToFragments(ahadethFragment())
                    }

                    R.id.navquran -> {
                        navigateToFragments(moshafFragment())
                    }

                    R.id.navsebha -> {
                        navigateToFragments(sebhaFragment())
                    }

                    else -> {
                        navigateToFragments(radioFragment())
                    }
                }

                return true
            }
        })
    }

    fun navigateToFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, fragment).commit()
    }
}