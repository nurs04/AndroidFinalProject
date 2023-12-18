package com.example.practiceproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Model.SceduleData
import com.example.practiceproject.R

class ScheduleAdapter(
    private val context: Context,
    private val scheduleList: List<SceduleData>
): RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder (view:View): RecyclerView.ViewHolder(view){
        val dataSchedule = view.findViewById<TextView>(R.id.date_schedule)
        val dayScedule = view.findViewById<TextView>(R.id.dateWeek_schedule)
        val nameDay = view.findViewById<TextView>(R.id.nameDay_schedule)
        val dayLeft = view.findViewById<TextView>(R.id.how_many_day_left)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scedule_maket, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun getItemCount() = scheduleList.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ScheduleViewHolder, position: Int) {
        val current = scheduleList[position]
        holder.dataSchedule.text = current.date.toString()
        holder.dayScedule.text = current.dateWeekDay
        holder.nameDay.text = current.eventName
        holder.dayLeft.text = current.dayLeft.toString() + " КҮН ҚАЛДЫ"
    }
}