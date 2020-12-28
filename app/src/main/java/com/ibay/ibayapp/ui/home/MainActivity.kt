package com.ibay.ibayapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ibay.ibayapp.R
import com.ibay.ibayapp.databinding.ActivityMainBinding
import com.ibay.ibayapp.ui.auth.AuthActivity
import com.ibay.ibayapp.ui.auth.IbayAppAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()

    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_news -> navigate(R.id.newsFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}