package com.example.ard_survey.retrofit

import com.example.ard_survey.model.ModelResponse
import retrofit2.Call
import retrofit2.http.GET

// its used for retrofit client
// its interface for get json data from url
// ALL functions are declared here for get, post , put and delete data
interface ApiInterface {
    @GET("ard-feed-0.json")
    fun getServices() : Call<ModelResponse>

}