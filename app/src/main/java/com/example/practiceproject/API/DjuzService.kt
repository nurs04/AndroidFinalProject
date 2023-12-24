package com.example.practiceproject.API

import com.example.practiceproject.Model.EntireQuranModel
import com.example.practiceproject.Model.QuranNameData
import com.example.practiceproject.Model.Surah
import retrofit2.Response
import retrofit2.http.GET

interface DjuzService {
    @GET("quran")
    suspend fun getData(): Response<EntireQuranModel>
}