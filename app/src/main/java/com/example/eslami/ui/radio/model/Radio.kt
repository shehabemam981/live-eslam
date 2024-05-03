package com.example.eslami.ui.radio.model


import com.google.gson.annotations.SerializedName

data class Radio(
    @field:SerializedName("id")
    val id: Int?, // 10
    @field:SerializedName("name")
    val name: String?, // إذاعة الزين محمد أحمد
    @field:SerializedName("recent_date")
    val recentDate: String?, // 2020-04-25 13:04:04
    @field:SerializedName("url")
    val url: String? // https://backup.qurango.net/radio/alzain_mohammad_ahmad
)