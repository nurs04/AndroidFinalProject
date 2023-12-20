package com.example.practiceproject.API

import com.example.practiceproject.Model.PrayTimeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NamazTimeApi {
    @GET("api/praytimes")
    suspend fun getPrayerTimes(
        @Query("id") cityId: String,
        @Query("type") type: String
    ): Response<PrayTimeModel>
}