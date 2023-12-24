package com.example.practiceproject.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.API.DjuzService
import com.example.practiceproject.API.SurahService
import com.example.practiceproject.Adapters.DjuzAdapter
import com.example.practiceproject.Adapters.QuranAdapter
import com.example.practiceproject.Adapters.SurahAdapter
import com.example.practiceproject.Model.Ayah
import com.example.practiceproject.Model.EntireQuranModel
import com.example.practiceproject.Model.QuranData
import com.example.practiceproject.Model.Surah
import com.example.practiceproject.Model.SurahData
import com.example.practiceproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DjuzFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var quranAdapter: QuranAdapter
    private lateinit var quranList: ArrayList<QuranData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_djuz, container, false)
        recyclerView = view.findViewById(R.id.djuz_recycler)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
//        setupRecyclerView()
//        loadData()
    }

//    private fun setupRecyclerView() {
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        djuzAdapter = DjuzAdapter(requireContext(), quranList)
//        recyclerView.adapter = djuzAdapter
//    }
//
//    private fun loadData() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.alquran.cloud/v1/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(DjuzService::class.java)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response: Response<EntireQuranModel> = service.getData()
//                if (response.isSuccessful) {
//                    val data = response.body()
//                    data?.let {
//                        quranList = it.data.surahs.flatMap { surah -> surah.ayahs }
//                        update(quranList)
//                    }
//                } else {
//                    val errorBody = response.errorBody()?.string()
//                    Log.e("DjuzFragment", "Ошибка: ${response.code()}, ${errorBody ?: "Unknown error"}")
//                }
//            } catch (e: Exception) {
//                Log.e("DjuzFragment", "Exception: ${e.message}")
//            }
//        }
//    }
//
//    private fun update(data: List<Ayah>) {
//        requireActivity().runOnUiThread {
//            djuzAdapter.updateData(data)
//        }
//    }

    private fun init() {
        quranList = ArrayList()
        quranList.apply{
            add(QuranData("بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ","С Именем Аллаhа, Милостивого для всех на этом\nсвете и только для верующих на Том свете", 1))
            add(QuranData("ٱلۡحَمۡدُ لِلَّهِ رَبِّ ٱلۡعَٰلَمِينَ","Хвала — Аллаху, Господу миров", 2))
            add(QuranData("ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ","Всемилостив и милосерден (Он Один)", 3))
            add(QuranData("مَٰلِكِ يَوۡمِ ٱلدِّينِ","Дня Судного Один Он властелин.", 4))
            add(QuranData("إِيَّاكَ نَعۡبُدُ وَإِيَّاكَ نَسۡتَعِينُ","Мы предаёмся лишь Тебе\nИ лишь к Тебе о помощи взываем:", 5))
            add(QuranData("ٱهۡدِنَا ٱلصِّرَٰطَ ٱلۡمُسۡتَقِيمَ","Направь прямой стезёю нас", 6))
            add(QuranData("صِرَٰطَ ٱلَّذِينَ أَنۡعَمۡتَ عَلَيۡهِمۡ غَيۡرِ ٱلۡمَغۡضُوبِ\n عَلَيۡهِمۡ وَلَا ٱلضَّآلِّين","Стезёю тех,Кто милостью Твоею одарён,\nА не стезёю тех, на ком Твой гнев,\nИ не стезёй заблудших.", 7))
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        quranAdapter = QuranAdapter(requireContext(), quranList)
        recyclerView.adapter = quranAdapter
    }
}