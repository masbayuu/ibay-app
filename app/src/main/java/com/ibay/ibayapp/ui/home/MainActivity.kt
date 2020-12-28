package com.ibay.ibayapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ibay.ibayapp.R
import com.ibay.ibayapp.databinding.ActivityMainBinding
import com.ibay.ibayapp.ui.auth.AuthActivity
import com.ibay.ibayapp.ui.auth.IbayAppAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            IbayAppAuth.logout(this) {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}