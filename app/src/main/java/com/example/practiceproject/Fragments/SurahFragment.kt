package com.example.practiceproject.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.API.SurahService
import com.example.practiceproject.Adapters.SurahAdapter
import com.example.practiceproject.Model.QuranNameData
import com.example.practiceproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response

class SurahFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var surahAdapter: SurahAdapter
    private var surahList: List<QuranNameData> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_surah, container, false)

        recyclerView = view.findViewById(R.id.recycler_of_surah)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        surahAdapter = SurahAdapter(requireContext(), surahList)
        recyclerView.adapter = surahAdapter
        loadData()
        return view
    }
    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.alquran.cloud/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SurahService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response<QuranNameData> = service.getSurahData()
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        surahList = listOf(it)
                        updateAdapter(surahList)
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("SurahFragment", "Ошибка: ${response.code()}, ${errorBody ?: "Unknown error"}")
                }
            } catch (e: Exception) {
                Log.e("SurahFragment", "Exception: ${e.message}")
            }
        }
    }
    private fun updateAdapter(data: List<QuranNameData>) {
        requireActivity().runOnUiThread {
            surahAdapter.updateData(data)
        }
    }
}