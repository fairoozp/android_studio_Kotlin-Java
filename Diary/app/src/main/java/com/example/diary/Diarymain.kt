package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Diarymain : AppCompatActivity() {

    private val db : DatabaseHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diary_main)

        val ddate : TextView = findViewById(R.id.ddate)
        val d = intent.getStringExtra("d")
        ddate.text = d
        val id = d.toString()

        val impbt : ImageButton = findViewById(R.id.impbt)
        val imptv : TextView = findViewById(R.id.imptv)
        val impetv : EditText = findViewById(R.id.impetv)
        impetv.visibility=View.INVISIBLE
        var x = 0
        var impstr = "just trying edit text"
        impetv.setText(impstr, TextView.BufferType.EDITABLE)
        imptv.text = impstr
        impbt.setOnClickListener {
            if(x == 0){
                imptv.visibility= View.INVISIBLE
                impetv.visibility = View.VISIBLE
                impbt.setImageResource(R.drawable.save)
                x = 1
            }
            else {
                imptv.visibility= View.VISIBLE
                impetv.visibility = View.INVISIBLE
                impbt.setImageResource(R.drawable.edit)
                imptv.text = impetv.text
                impstr = imptv.text.toString()

                val imp = impstr
                val result : Boolean = db.insert(id,imp)
                when{
                    result -> Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
                x = 0
            }
        }
        val dbt : ImageButton = findViewById(R.id.dbt)
        val dtv : TextView = findViewById(R.id.dtv)
        val detv : EditText = findViewById(R.id.detv)
        detv.visibility=View.INVISIBLE
        var dstr = "diary editable"
        dtv.text = dstr
        detv.setText(dstr, TextView.BufferType.EDITABLE)
        var y = 0
        dbt.setOnClickListener {
            if(y == 0){
                dtv.visibility = View.INVISIBLE
                detv.visibility = View.VISIBLE
                dbt.setImageResource(R.drawable.save)
                y = 1
            }
            else{
                dtv.visibility = View.VISIBLE
                detv.visibility = View.INVISIBLE
                dbt.setImageResource(R.drawable.edit)
                dtv.text = detv.text
                dstr = dtv.text.toString()
                y = 0
            }
        }
        val home : Button = findViewById(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun readdata(){
        val data = db.read()
        val stringBuffer = StringBuffer()
        if (data != null && data.count>0){
            
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Please Press Home Button", Toast.LENGTH_SHORT).show()
        //super.onBackPressed()
    }
}