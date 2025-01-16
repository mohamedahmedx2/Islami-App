package com.example.islami.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.home.tabs.RadioFragment
import com.example.islami.home.tabs.TasbehFragment
import com.example.islami.home.tabs.hadeth.HadethFragment
import com.example.islami.home.tabs.quran.QuranFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            val fragment: Fragment = when (menuItem.itemId) {
                R.id.nav_quran -> {
                    QuranFragment()
                }

                R.id.nav_hadeeth -> {
                    HadethFragment()
                }

                R.id.nav_sebha -> {
                    TasbehFragment()
                }

                R.id.nav_radio -> {
                    RadioFragment()
                }

                else -> {
                    RadioFragment()
                }

            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
        binding.bottomNavView.selectedItemId = R.id.nav_quran
    }

    fun showFragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()

    }
}


