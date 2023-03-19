package com.example.myapplication01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication01.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_item_1 -> replaceFragment(home())
                R.id.menu_item_2 -> replaceFragment(category())
                R.id.menu_item_3 -> replaceFragment(profile())
                R.id.menu_item_4 -> replaceFragment(cart())
                R.id.menu_item_5 -> replaceFragment(selling())

                else -> {

                }
            }
            true
        }

    }

    private fun replaceFragment (fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}