package com.example.practiceproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Model.QuranNameData
import com.example.practiceproject.Model.SurahData
import com.example.practiceproject.R

class SurahAdapter(
    private val context: Context,
    private var surahList: List<QuranNameData>
) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quran_maket, parent, false)
        return SurahViewHolder(view)
    }

    override fun getItemCount() = surahList.flatMap { it.data }.size

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val flatList = surahList.flatMap { it.data }
        val currentSurah = flatList[position]
        holder.numberOfSurah.text = currentSurah.number.toString()
        holder.nameSurah.text = currentSurah.englishName
        holder.numbOfAyah.text = currentSurah.numberOfAyahs.toString() + " aят"
    }

    class SurahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val numberOfSurah: TextView = itemView.findViewById(R.id.numberOfSurah)
        val nameSurah: TextView = itemView.findViewById(R.id.name_surah)
        val numbOfAyah: TextView = itemView.findViewById(R.id.numberOfAyat)
    }
    fun updateData(newData: List<QuranNameData>) {
        surahList = newData
        notifyDataSetChanged()
    }
}
