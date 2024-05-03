package com.example.eslami.ui.radio.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiManager {
    private var retrofit: Retrofit? = null

    private fun getInstance(): Retrofit {
        return if (retrofit == null) {
            val client = OkHttpClient
                .Builder()
//            .addInterceptor(initLogging())
                .build()

            Retrofit.Builder()
                .client(client)
                .baseUrl("https://mp3quran.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        } else retrofit!!
    }





    private fun initLogging(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    log(message)
                }
            }
        )
        logging.setLevel(level = HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    fun webService(): WebService {
        return getInstance().create(WebService::class.java)
    }
}