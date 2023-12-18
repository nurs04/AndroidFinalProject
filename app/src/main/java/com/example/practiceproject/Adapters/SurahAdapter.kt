package com.example.practiceproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Model.SurahData
import com.example.practiceproject.R

class SurahAdapter(
    private val context: Context,
    private val surahList: List<SurahData>
) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quran_maket, parent, false)
        return SurahViewHolder(view)
    }

    override fun getItemCount() = surahList.size

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val currentSurah = surahList[position]
        holder.numberOfSurah.text = currentSurah.number.toString()
        holder.nameSurah.text = currentSurah.name
        holder.numberOfAyah.text = currentSurah.numOfAyahs.toString() + " aят"
    }

    class SurahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val numberOfSurah: TextView = itemView.findViewById(R.id.numberOfSurah)
        val nameSurah: TextView = itemView.findViewById(R.id.name_surah)
        val numberOfAyah: TextView = itemView.findViewById(R.id.numberOfAyat)
    }

}
