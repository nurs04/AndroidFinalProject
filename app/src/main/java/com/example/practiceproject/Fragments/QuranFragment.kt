package com.example.practiceproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.practiceproject.R

class QuranFragment : Fragment() {
    private lateinit var suraFragment: SurahFragment
    private lateinit var juzFragment: DjuzFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quran, container, false)
        suraFragment = SurahFragment()
        juzFragment = DjuzFragment()

        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_juz, suraFragment)
            commit()
        }

        view.findViewById<TextView>(R.id.sura).setOnClickListener {
            showSuraFragment()
        }

        view.findViewById<TextView>(R.id.juz).setOnClickListener {
            showJuzFragment()
        }
        return view
    }

    private fun showSuraFragment() {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_juz, suraFragment)
            commit()
        }
    }

    private fun showJuzFragment() {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_juz, juzFragment)
            commit()
        }
    }
}
