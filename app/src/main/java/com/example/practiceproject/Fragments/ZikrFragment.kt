package com.example.practiceproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Adapters.ZikrAdapter
import com.example.practiceproject.Model.ZikrData
import com.example.practiceproject.R

class ZikrFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var zikrList : ArrayList<ZikrData>
    private lateinit var zikrAdapter: ZikrAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_zikr, container, false)
        recyclerView = view.findViewById(R.id.zikr_recycler)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        zikrList = ArrayList()
        zikrList.run {
            add(ZikrData(1, "Лә иләhә илләллаh", "Лә иләhә илләллаh.", 0))
            add(ZikrData(2, "Салауат", "Аллаaһуммә солли 'әләә \nMухәммадин уә 'әләә әәли \nМyхәммад.", 0))
            add(ZikrData(3, "Әстәғфируллаah", "Әстәғфируллаah.", 0))
            add(ZikrData(4, "Субханналаh", "Субханналаh.", 0))
            add(ZikrData(5, "Әлхәмдулилләh", "Әл-xәмду лилләh.", 0))
            add(ZikrData(6, "Aллahу Әкбар", "Aллahу әкбар.", 0))
            add(ZikrData(7, "Субхааналлаһи уә бихамдиһ", "СубхаанАллаһи уә бихамдиһ,\nсубхаанАллаһил‘азыйим.", 0))
            add(ZikrData(8, "Кәлимә", "Лә иләhә илләллаh,\nмухәммәдур-рассуулюллааh", 0))
            add(ZikrData(9, "Ата-анағажасалатын дұға", "Рабби-рхәмуhумәә кәмәә\nраббаяянии соғыыраа", 0))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        zikrAdapter = ZikrAdapter(requireContext(), zikrList)
        recyclerView.adapter = zikrAdapter
        }
    }
}