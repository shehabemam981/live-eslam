package com.example.eslami.ui.moshaf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eslami.R
import com.example.eslami.databinding.ActivityMoshafDetailsBinding

class MoshafDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMoshafDetailsBinding
    lateinit var title: String
    var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoshafDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = intent.getStringExtra(constant.item) ?: ""
        index = intent.getIntExtra(constant.position,0 )
        binding.titleDetails.text = title
        initRec()
        backButton()
    }

    private fun backButton() {
        binding.backToMain.setOnClickListener {
            onBackPressed()
        }
    }

    private fun readQuran(): List<String> {
    val openAssets = assets.open("$index.txt")
      val reader =  openAssets.bufferedReader().use {
           it.readText()
       }.trim().split("\n")
     return reader
    }

    private fun initRec() {
        val adapter = adapterDetails(readQuran())
        binding.contentDetailedRv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}