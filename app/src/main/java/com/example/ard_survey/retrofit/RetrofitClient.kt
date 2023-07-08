package com.example.ard_survey.retrofit

import com.example.ard_survey.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// its used for retrofit client
object RetrofitClient {

    // its base url of json file link
    const val MainServer = "https://storage.googleapis.com/fra-uas-mobappex-ss23-amin/24-04-2023/"

    val retrofitClient: Retrofit.Builder by lazy {

        val levelType: Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        // its used for convert json data to kotlin class
        // its used in ApiInterface.kt
        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}
