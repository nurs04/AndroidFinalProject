package com.example.practiceproject.ViewModel

import androidx.lifecycle.ViewModel
import com.example.practiceproject.API.NamazTimeApi
import com.example.practiceproject.API.SurahService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SurahPageViewModel: ViewModel() {

    private val retrofitService = Retrofit.Builder()
        .baseUrl("https://api.alquran.cloud/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SurahService::class.java)

}