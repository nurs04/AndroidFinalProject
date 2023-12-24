package com.example.practiceproject.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.practiceproject.R
import com.example.practiceproject.R.id.mosque_background

class FonFragment : Fragment() {
    private lateinit var img1 :ImageView
    private lateinit var img2 :ImageView
    private lateinit var img3 :ImageView
    private lateinit var img4 :ImageView
    private lateinit var img5 :ImageView
    private lateinit var img6 :ImageView
    private lateinit var mainMenuImg:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fon, container, false)

        img1 = view.findViewById(R.id.first_img)
        img2 = view.findViewById(R.id.second_img)
        img3 = view.findViewById(R.id.third_img)
        img4 = view.findViewById(R.id.forth_img)
        img5 = view.findViewById(R.id.fifth_img)
        img6 = view.findViewById(R.id.sixth_img)

        img1.setOnClickListener{
//            photoChanger(R.drawable.mosque_back)
        }
        img2.setOnClickListener{
//            photoChanger(R.drawable.mosque_background)
        }
        img3.setOnClickListener{
//            photoChanger(R.drawable.mosque_1)
        }
        img4.setOnClickListener{
//            photoChanger(R.drawable.mosque_2)
        }
        img5.setOnClickListener{
//            photoChanger(R.drawable.mosque_3)
        }
        img6.setOnClickListener{
//            photoChanger(R.drawable.mosque_4)
        }

        return view
    }

//    private fun photoChanger(img: Int){
//        mainMenuImg.setImageResource(img)
//    }
}