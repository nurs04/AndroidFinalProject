package com.example.practiceproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Model.Ayah
import com.example.practiceproject.Model.EntireQuranModel
import com.example.practiceproject.Model.QuranData
import com.example.practiceproject.Model.QuranNameData
import com.example.practiceproject.Model.Surah
import com.example.practiceproject.R

class DjuzAdapter(
    private val context: Context,
    private var quranList: List<QuranData>
): RecyclerView.Adapter<DjuzAdapter.DjuzViewHolder>(){
    class DjuzViewHolder(view: View): RecyclerView.ViewHolder(view){
        val arabics = view.findViewById<TextView>(R.id.arabic)
        val translationn = view.findViewById<TextView>(R.id.translation)
        val numberr = view.findViewById<TextView>(R.id.ayah_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DjuzViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.djuz_maket, parent, false)
        return DjuzViewHolder(view)
    }

    override fun getItemCount() = quranList.size

    override fun onBindViewHolder(holder: DjuzViewHolder, position: Int) {
        val currentSurah = quranList[position]
        holder.arabics.text = currentSurah.arabic
        holder.translationn.text = currentSurah.translation
        holder.numberr.text = currentSurah.numOfAyah.toString()
    }
//    fun updateData(newData: List<Ayah>) {
//        quranList = newData
//        notifyDataSetChanged()
//    }
}