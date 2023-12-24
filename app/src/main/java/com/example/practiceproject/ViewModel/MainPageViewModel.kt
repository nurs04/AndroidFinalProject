package com.example.practiceproject.ViewModel
import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceproject.API.NamazTimeApi
import com.example.practiceproject.Model.PrayTimeModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainPageViewModel : ViewModel() {
    private val _currentTime = MutableLiveData<String>()
    val currentTime: LiveData<String>
        get() = _currentTime

    private val _currentWeekDay = MutableLiveData<String>()
    val currentWeekDay: LiveData<String>
        get() = _currentWeekDay

    private val _currentDay = MutableLiveData<String>()
    val currentDay: LiveData<String>
        get() = _currentDay

    private val _prayerTimes = MutableLiveData<PrayTimeModel>()
    val prayerTimes: LiveData<PrayTimeModel>
        get() = _prayerTimes

    private val retrofitService = Retrofit.Builder()
        .baseUrl("https://namaztimes.kz/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NamazTimeApi::class.java)
    init {
        updateTime()
        fetchPrayerTimes()
    }

    private fun updateTime() {
        val handler = android.os.Handler()
        handler.postDelayed({
            val currentTime = getCurrentTimeInTimeZone("GMT+6")
            _currentTime.value = currentTime
            val calendar = Calendar.getInstance()
            val weekDayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
            val dayFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

            val weekDay = weekDayFormat.format(calendar.time)
            val day = dayFormat.format(calendar.time)

            _currentWeekDay.value = weekDay
            _currentDay.value = day
            updateTime()
        }, 1000)
    }

    private fun getCurrentTimeInTimeZone(timeZone: String): String {
        val sdf = SimpleDateFormat("H:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone(timeZone)
        return sdf.format(Date())
    }

    private fun fetchPrayerTimes() {
        viewModelScope.launch {
                val response = retrofitService.getPrayerTimes("8408", "=json")
                if (response.isSuccessful) {
                    _prayerTimes.value = response.body()
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("SurahFragment", "Ошибка: ${response.code()}, ${errorBody ?: "Unknown error"}")
                }

        }
    }

   fun updatePrayerTimesForCityAndType(cityId: String, type: String) {
        viewModelScope.launch {
            try {
                val response = retrofitService.getPrayerTimes(cityId, type)
                if (response.isSuccessful) {
                    _prayerTimes.value = response.body()
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("MainPageFragment", "Ошибка: ${response.code()}, ${errorBody ?: "Unknown error"}")
                }
            } catch (e: IOException) {
                Log.e("MainPageFragment", "Ошибка сети: ${e.message}")
            }
        }
    }
}