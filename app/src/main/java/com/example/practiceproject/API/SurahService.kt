//package com.example.practiceproject.API
//import retrofit2.Call
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//
//interface SurahService {
//    @GET("surah")
//    fun getSurahData(): Call<List<Data>>
//}
//
//class SurahApiClient {
//    companion object {
//        private const val BASE_URL = "http://api.alquran.cloud/v1/"
//        fun create(): SurahService {
//            val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//
//            return retrofit.create(SurahService::class.java)
//        }
//    }
//}