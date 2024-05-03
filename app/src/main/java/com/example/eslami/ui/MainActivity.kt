package com.example.eslami.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.viewbinding.ViewBinding
import com.example.eslami.R
import com.example.eslami.databinding.ActivityMainBinding
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed(
            {
                startActivity(Intent(this,HomeActivity::class.java))
                finish()

            }
        ,2000)

    }
}