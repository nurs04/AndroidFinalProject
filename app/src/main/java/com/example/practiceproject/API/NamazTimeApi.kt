package com.example.practiceproject.API

import com.example.practiceproject.Model.PrayTimeModel
import retrofit2.Response
import retrofit2.http.GET

interface NamazTimeApi {
    @GET("api/praytimes?id=8408&type=json")
    suspend fun getPrayerTimes(): Response<PrayTimeModel>
}