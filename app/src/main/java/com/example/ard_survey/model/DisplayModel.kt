package com.example.ard_survey.model


// its model class for get imageurl and videolink from json
// its used in ARDSurveryAdapter.kt
data class DisplayModel
    (
    val imageurl: String = "",
    val videolink: String? = "",
    val title: String? = "",
    val showtype: String? = "",
)