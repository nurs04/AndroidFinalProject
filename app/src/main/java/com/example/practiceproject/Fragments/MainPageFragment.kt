package com.example.practiceproject.Fragments

import QiblaFragment
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.practiceproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


class MainPageFragment : Fragment() {
    private lateinit var timeTextView: TextView
    private val handler = Handler()
    private val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)
        timeTextView = view.findViewById(R.id.current_time)
        updateTime()
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_btn1 -> {
                    openQiblaFragment()
                    true
                }
                R.id.navigation_btn2 -> {
                    showBottomSheetDialog()
                    true
                }
                R.id.navigation_btn3 -> {
                    true
                }
                else -> false
            }
        }

        return view
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.overlay_for_main_menu, null)

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }
    private fun openQiblaFragment() {
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        val qiblaFragment = QiblaFragment()

        fragmentTransaction.replace(R.id.fragment_container, qiblaFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun updateTime() {
        handler.postDelayed({
            val currentTime = getCurrentTimeInTimeZone("GMT+6")
            timeTextView.text = currentTime
            updateTime()
        }, 1000)
    }

    private fun getCurrentTimeInTimeZone(timeZone: String): String {
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone(timeZone)
        return sdf.format(Date())
    }
}