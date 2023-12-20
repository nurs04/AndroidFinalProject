package com.example.practiceproject.API

import com.example.practiceproject.Model.QuranNameData
import retrofit2.Response
import retrofit2.http.GET

interface DjuzService {
    @GET("quran")
    suspend fun getSurahData(): Response<QuranNameData>
}