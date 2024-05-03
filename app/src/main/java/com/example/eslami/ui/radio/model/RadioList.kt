package com.example.eslami.ui.radio.model


import com.google.gson.annotations.SerializedName

data class RadioList(
    @field:SerializedName("radios")
    val radios: List<Radio?>?
)