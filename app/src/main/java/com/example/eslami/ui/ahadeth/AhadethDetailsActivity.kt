package com.example.eslami.ui.ahadeth

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.eslami.databinding.ActivityAhadethDetailsBinding

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAhadethDetailsBinding
     var ahadeth: ahadethModel? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        content()
    backButton()
    }

    private fun backButton() {
        binding.backToMain.setOnClickListener {
            onBackPressed()
        }
    }


    private fun initView() {
        if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ahadeth = intent.getParcelableExtra(constantAhadeth.hadeth,ahadethModel::class.java)
        }

      ahadeth = intent.getParcelableExtra<ahadethModel>(constantAhadeth.hadeth)
    }

    private fun content() {

        ahadeth.let {ahadeth->
            binding.contentDetails.text = ahadeth?.content
            binding.titleDetails.text = ahadeth?.title
        }

    }


}