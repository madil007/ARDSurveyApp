package com.example.ard_survey.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ard_survey.model.ModelResponse
import com.example.ard_survey.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// its repository class for get data from api
object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ModelResponse>()

    fun getServicesApiCall(): MutableLiveData<ModelResponse> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object : Callback<ModelResponse> {
            override fun onFailure(call: Call<ModelResponse>, t: Throwable) {
                // its for error
                // if there is any error in api then it will show here
                Log.d("ERORRRS ", t.message.toString())
            }

            // success response
            override fun onResponse(
                call: Call<ModelResponse>,
                response: Response<ModelResponse>
            ) {

                // its for success response
                // map the response to our MutableLiveData
                serviceSetterGetter.value = response.body()

            }
        })

        return serviceSetterGetter

    }
}