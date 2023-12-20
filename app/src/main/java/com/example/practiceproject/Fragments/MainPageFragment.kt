package com.example.practiceproject.Fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.practiceproject.R
import com.example.practiceproject.ViewModel.MainPageViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
class MainPageFragment : Fragment() {
    private lateinit var tan: TextView
    private lateinit var kun: TextView
    private lateinit var besin: TextView
    private lateinit var asr: TextView
    private lateinit var aqsham: TextView
    private lateinit var quptan: TextView
    private lateinit var day: TextView
    private lateinit var weekDay: TextView
    private lateinit var viewModel: MainPageViewModel
    private lateinit var timeTextView: TextView
    private lateinit var tanLayout: LinearLayout
    private lateinit var kunLayout: LinearLayout
    private lateinit var besinLayout: LinearLayout
    private lateinit var asrLayout: LinearLayout
    private lateinit var aqshamLayout: LinearLayout
    private lateinit var quptanLayout: LinearLayout
    private lateinit var location: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)
//        val scaleUp = AnimationUtils.loadAnimation(requireContext(), R.anim.scale_up)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)
        location = view.findViewById<TextView>(R.id.location_text)

        location.setOnClickListener {
            showCitySelected()
        }

        timeTextView = view.findViewById(R.id.current_time)
        weekDay = view.findViewById(R.id.week_day)
        day = view.findViewById(R.id.day_in_hijr)
        tan = view.findViewById(R.id.namaz_time_1)
        kun = view.findViewById(R.id.namaz_time_2)
        besin = view.findViewById(R.id.namaz_time_3)
        asr = view.findViewById(R.id.namaz_time_4)
        aqsham = view.findViewById(R.id.namaz_time_5)
        quptan = view.findViewById(R.id.namaz_time_6)
        tanLayout = view.findViewById(R.id.first_linear)
        kunLayout = view.findViewById(R.id.second_linear)
        besinLayout = view.findViewById(R.id.third_linear)
        asrLayout = view.findViewById(R.id.forth_linear)
        aqshamLayout = view.findViewById(R.id.fives_linear)
        quptanLayout = view.findViewById(R.id.six_linear)
        viewModel = ViewModelProvider(this).get(MainPageViewModel::class.java)
        viewModel.currentTime.observe(viewLifecycleOwner) { currentTime ->
            timeTextView.text = currentTime
        }
        viewModel.currentWeekDay.observe(viewLifecycleOwner) { observedWeekDay ->
            weekDay.text = observedWeekDay
        }
        viewModel.currentDay.observe(viewLifecycleOwner) { observedDay ->
            day.text = observedDay
        }
        viewModel.prayerTimes.observe(viewLifecycleOwner){observedPrayTime ->
            observedPrayTime?.let {
                val tanN = it.praytimes.bamdat
                val kunN = it.praytimes.kun
                val besinN = it.praytimes.besin
                val asrN = it.praytimes.ekindi
                val aqshamN = it.praytimes.aqsham
                val quptanN = it.praytimes.quptan
                tan.text = tanN
                kun.text = kunN
                besin.text = besinN
                asr.text = asrN
                aqsham.text = aqshamN
                quptan.text = quptanN

                changeBackgroundIfTimeMatches(timeTextView.text.toString(), tanN, tanLayout)
                changeBackgroundIfTimeMatches(timeTextView.text.toString(), kunN, kunLayout)
                changeBackgroundIfTimeMatches(timeTextView.text.toString(), besinN, besinLayout)
                changeBackgroundIfTimeMatches(timeTextView.text.toString(), asrN, asrLayout)
                changeBackgroundIfTimeMatches(timeTextView.text.toString(), aqshamN, aqshamLayout)
                changeBackgroundIfTimeMatches(timeTextView.text.toString(), quptanN, quptanLayout)
            }
        }
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
                    openQuranFragment()
                    true
                }
                else -> false
            }
        }
//        setOnClick()
        return view
    }
    val cityIdMap = mapOf(
        "Актау" to "8376",
        "Алматы" to "8408",
        "Астана" to "8359",
        "Бейнеу" to "8365",
        "Жаркент" to "8420",
        "Мангышлак" to "8369",
        "Талды-Курган" to "8423",
        "Талгар" to "62459",
        "Шетпе" to "8375",
        "Уштобе" to "8426"
    )
    private fun showCitySelected() {
        val cityList = cityIdMap.keys.toTypedArray()
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите город")
        builder.setItems(cityList) { dialog, which ->
            val selectedCity = cityList[which]
            location.text = selectedCity
            val cityId = cityIdMap[selectedCity]
            cityId?.let {
                viewModel.updatePrayerTimesForCityAndType(it, "=json")
            }
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.overlay_for_main_menu, null)

        bottomSheetDialog.setContentView(view)
        val zikr = view.findViewById<TextView>(R.id.zikr)
        val schedule = view.findViewById<TextView>(R.id.schedule)
        val fon = view.findViewById<TextView>(R.id.fon)
        val setting = view.findViewById<TextView>(R.id.settings)

        zikr.setOnClickListener{
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val zikrFragment = ZikrFragment()
            fragmentTransaction.replace(R.id.fragment_container, zikrFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            bottomSheetDialog.dismiss()

        }

        schedule.setOnClickListener{
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val scheduleFragment = ScheduleFragment()
            fragmentTransaction.replace(R.id.fragment_container, scheduleFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            bottomSheetDialog.dismiss()
        }

        fon.setOnClickListener{
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val fonFragment = FonFragment()
            fragmentTransaction.replace(R.id.fragment_container, fonFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            bottomSheetDialog.dismiss()
        }
        setting.setOnClickListener{
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val settingsFragment = SettingsFragment()
            fragmentTransaction.replace(R.id.fragment_container, settingsFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
    private fun openQiblaFragment() {
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        val qiblaFragment = QiblaFragment()

        fragmentTransaction.replace(R.id.fragment_container, qiblaFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun openQuranFragment() {
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        val quranFragment = QuranFragment()

        fragmentTransaction.replace(R.id.fragment_container, quranFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun changeBackgroundIfTimeMatches(currentTime: String, textViewTime: String, layoutToChange: LinearLayout) {
        val currentTimeWithoutSeconds = currentTime.substring(0, 5)
        if (currentTimeWithoutSeconds == textViewTime) {
            layoutToChange.setBackgroundResource(R.color.backGreen)
        }
    }

//    private fun setOnClick(){
//        val vol1 = view?.findViewById<ImageView>(R.id.volume1)
//        val vol2 = view?.findViewById<ImageView>(R.id.volume2)
//        val vol3 = view?.findViewById<ImageView>(R.id.volume3)
//        val vol4 = view?.findViewById<ImageView>(R.id.volume4)
//        val vol5 = view?.findViewById<ImageView>(R.id.volume5)
//        val vol6 = view?.findViewById<ImageView>(R.id.volume6)
//
//        setImage(vol1!!, R.drawable.volume_cross)
//        setImage(vol2!!, R.drawable.volume_cross)
//        setImage(vol3!!, R.drawable.volume_cross)
//        setImage(vol4!!, R.drawable.volume_cross)
//        setImage(vol5!!, R.drawable.volume_cross)
//        setImage(vol6!!, R.drawable.volume_cross)
//    }
//
//    private fun setImage(imageView: ImageView, newItem: Int){
//        imageView.setOnClickListener{
//            imageView.setImageResource(newItem)
//        }
//    }
}