package com.android.mywallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.mywallet.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var amount_home : EditText
    lateinit var amount_reminder : EditText
    lateinit var balance : TextView
    lateinit var income : TextView
    lateinit var expence : TextView
    lateinit var usage : TextView
    lateinit var add_home : ImageButton
    lateinit var sub_home : ImageButton
    lateinit var add_reminder : ImageButton
    lateinit var sub_reminder : ImageButton
    lateinit var submit : Button
    lateinit var delete : Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        myfunction()
        return root
    }

    private fun myfunction() {
        //add_home.setOnClickListener {
            //balance.text=2000.toString()
        //}
    }
}