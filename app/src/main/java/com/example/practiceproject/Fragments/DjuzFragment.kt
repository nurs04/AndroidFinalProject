package com.example.practiceproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Adapters.QuranAdapter
import com.example.practiceproject.Adapters.SurahAdapter
import com.example.practiceproject.Model.QuranData
import com.example.practiceproject.Model.SurahData
import com.example.practiceproject.R

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
    }

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