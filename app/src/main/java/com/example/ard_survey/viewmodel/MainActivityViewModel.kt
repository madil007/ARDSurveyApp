package com.example.mvvmkotlinexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ard_survey.model.ModelResponse
import com.example.ard_survey.repository.MainActivityRepository


// viewmodel class for get data from repository
// its used in ResultActivity.kt
// its used for MVVM architecture
// observe the data from repository
class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<ModelResponse>? = null

    // get data from repository
    fun getUser() : LiveData<ModelResponse>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}