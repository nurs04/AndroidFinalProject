package com.example.practiceproject.Fragments

import QiblaFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practiceproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainPageFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)

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
}