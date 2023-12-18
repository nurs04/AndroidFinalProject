package com.example.practiceproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Adapters.SurahAdapter
import com.example.practiceproject.Model.SurahData
import com.example.practiceproject.R

class SurahFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var surahAdapter: SurahAdapter
    private lateinit var surahList: ArrayList<SurahData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_surah, container, false)

        recyclerView = view.findViewById(R.id.recycler_of_surah)
//        fetchDataFromAPI()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        surahList = ArrayList()
        surahList.run {
            add(SurahData(1, "Аль-Фатиха", 7))
            add(SurahData(2, "Аль-Бакара", 286))
            add(SurahData(3, "Аль Имран", 200))
            add(SurahData(4, "Ан-Ниса", 176))
            add(SurahData(5, "Аль-Маида", 120))
            add(SurahData(6, "Аль-Анам", 165))
            add(SurahData(7, "Аль-Араф", 206))
            add(SurahData(8, "Аль-Анфаль", 75))
            add(SurahData(9, "Ат-Тавба", 129))
            add(SurahData(10, "Юнус", 123))
            add(SurahData(11, "Худ", 111))
            add(SurahData(12, "Юсуф", 43))
            add(SurahData(13, "Ар-Рад", 54))
            add(SurahData(14, "Ибрахим", 52))
            add(SurahData(15, "Aр-Хижр", 99))
            add(SurahData(16, "Ан-Нахл", 128))
            add(SurahData(17, "Аль-Исра", 111))
            add(SurahData(18, "Аль-Кahф", 110))
            add(SurahData(19, "Мариам", 98))
            add(SurahData(20, "Таha", 135))
            add(SurahData(21, "Аль-Анбия", 112))
            add(SurahData(22, "Аль-Хаж", 78))
            add(SurahData(23, "Аль-Му'минун", 118))
            add(SurahData(24, "Ан-Нур", 64))
            add(SurahData(25, "Аль-Фуркан", 77))
            add(SurahData(26, "Ашь-Шу'aра", 227))
            add(SurahData(27, "Ан-Намл", 93))
            add(SurahData(28, "Аль-Касас", 88))
            add(SurahData(29, "Аль-Анкабут", 69))
            add(SurahData(30, "Ар-Рум", 60))
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        surahAdapter = SurahAdapter(requireContext(), surahList)
        recyclerView.adapter = surahAdapter

    }


//    private fun fetchDataFromAPI() {
//        val service = SurahApiClient.create().getSurahData()
//
//        service.enqueue(object : Callback<List<Data>> {
//            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
//                if (response.isSuccessful) {
//                    val surahDataList = response.body() ?: emptyList()
//                    Log.d("SurahResponse", "Response successful: $surahDataList")
//                    surahList = surahDataList
//                    surahAdapter.notifyDataSetChanged()
//                } else {
//                    val errorBody = response.errorBody()?.string()
//                    Log.e("SurahFragment", "Ошибка: ${response.code()}, ${errorBody ?: "Unknown error"}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
//                Log.e("SurahFragment", "Ошибка сети: ${t.message}", t)
//            }
//        })
//    }
}