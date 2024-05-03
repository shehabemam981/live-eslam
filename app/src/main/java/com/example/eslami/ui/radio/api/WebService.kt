package com.example.eslami.ui.radio.api

import com.example.eslami.ui.radio.model.RadioList
import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET("/api/v3/radios")
    fun getRadio():Call<RadioList>
}