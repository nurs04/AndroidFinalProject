package com.example.practiceproject.ui

import android.content.Context
import android.content.SharedPreferences
import com.example.practiceproject.R

class PrayerTimePreferences(private val context: Context) {
    private val PREFS_NAME = "PrayerTimePrefs"
    private val BACKGROUND_COLOR = "backgroundColor"
    private val TIMER_STATE = "timerState"
    private val MATCH_TEXT = "matchText"

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    var backgroundColor: Int
        get() = preferences.getInt(BACKGROUND_COLOR, R.drawable.background_for_time)
        set(value) = preferences.edit().putInt(BACKGROUND_COLOR, value).apply()

    var isTimerRunning: Boolean
        get() = preferences.getBoolean(TIMER_STATE, false)
        set(value) = preferences.edit().putBoolean(TIMER_STATE, value).apply()

    var matchText: String
        get() = preferences.getString(MATCH_TEXT, "") ?: ""
        set(value) = preferences.edit().putString(MATCH_TEXT, value).apply()
}