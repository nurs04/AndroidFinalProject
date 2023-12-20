package com.example.practiceproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceproject.Model.QuranData
import com.example.practiceproject.Model.QuranNameData
import com.example.practiceproject.R

class QuranAdapter(
    private val context: Context,
    private val quranList: List<QuranData>
): RecyclerView.Adapter<QuranAdapter.QuranViewHolder>(){
    class QuranViewHolder(view: View): RecyclerView.ViewHolder(view){
        val arabics = view.findViewById<TextView>(R.id.arabic)
        val translationn = view.findViewById<TextView>(R.id.translation)
        val numberr = view.findViewById<TextView>(R.id.ayah_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.djuz_maket, parent, false)
        return QuranViewHolder(view)
    }

    override fun getItemCount() = quranList.size

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        val current = quranList[position]
        holder.arabics.text = current.arabic
        holder.translationn.text = current.translation
        holder.numberr.text = current.numOfAyah.toString()
    }
}