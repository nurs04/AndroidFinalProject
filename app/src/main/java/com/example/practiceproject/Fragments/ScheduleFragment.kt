package com.example.practiceproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Adapters.ScheduleAdapter
import com.example.practiceproject.Adapters.SurahAdapter
import com.example.practiceproject.Model.SceduleData
import com.example.practiceproject.Model.SurahData
import com.example.practiceproject.R

class ScheduleFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var eventList: ArrayList<SceduleData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)

        recyclerView = view.findViewById(R.id.schedule_recycler)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        eventList = ArrayList()
        eventList.run {
            add(SceduleData(18, "Әл-Исра' уәл-Миғраж\n(Түнгі Көшу және Көтерілу)", "Февр.", 61))
            add(SceduleData(7, "Ләйләтуль-Бараат               \n(Құтылу Түні)", "март.", 79))
            add(SceduleData(23, "Рамазан (Ораза айы)        ", "март.", 95))
            add(SceduleData(18, "Ләйләтуль-Қадр (Қадір Түні)", " апр.", 121))
            add(SceduleData(21, "'Ид әл-Фитр (Ораза айт)   ", " апр.", 124))
            add(SceduleData(27, "'Арафат күні                         ", " июня", 191))
            add(SceduleData(28, "'Ид әл-Адха (Құрбан Айт)", " июня", 192))
            add(SceduleData(28, "'Ашура Күні                         ", " июля", 222))
            add(SceduleData(27, "Мәуліт (Мұхаммед\nПайғамбардың Туған Күні)", "сент", 283))
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        scheduleAdapter = ScheduleAdapter(requireContext(), eventList)
        recyclerView.adapter = scheduleAdapter
    }
}