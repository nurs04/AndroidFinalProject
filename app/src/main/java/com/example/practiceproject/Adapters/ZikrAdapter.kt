package com.example.practiceproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Model.ZikrData
import com.example.practiceproject.R

class ZikrAdapter(
    private val context: Context,
    private val zikrList : List<ZikrData>
): RecyclerView.Adapter<ZikrAdapter.ZikrViewHolder>(){
    class ZikrViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val zikr_number = itemView.findViewById<TextView>(R.id.number_zikr)
        val zikr_name = itemView.findViewById<TextView>(R.id.zikr_name)
        val zikr_text = itemView.findViewById<TextView>(R.id.zikr_words)
        val zikr_favorite = itemView.findViewById<ImageView>(R.id.zikr_favorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZikrViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.zikr_maket, parent, false)
        return ZikrViewHolder(view)
    }

    override fun getItemCount() = zikrList.size

    override fun onBindViewHolder(holder: ZikrViewHolder, position: Int) {
        val currentPosition = zikrList[position]
        holder.zikr_number.text = currentPosition.number.toString()
        holder.zikr_name.text = currentPosition.name
        holder.zikr_text.text = currentPosition.transkript
    }
}