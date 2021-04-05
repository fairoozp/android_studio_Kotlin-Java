package com.example.diary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cv : CalendarView = findViewById(R.id.cv)
        val date  : TextView = findViewById(R.id.ddate)
        var i = 0
        var d = ""
        cv.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val y : String = year.toString()
            val m : Int = month+1
            val dm : String = dayOfMonth.toString()
            d = "$dm/$m/$y"
            date.text = d
            i += 1
            Toast.makeText(this, "Date selected $d", Toast.LENGTH_SHORT).show()
        }
        val db : ImageButton = findViewById(R.id.db)
        db.setOnClickListener {
            if (i == 0)
            {
                Toast.makeText(this, "Select A Date First", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,Diarymain::class.java)
                intent.putExtra("d",d)
                startActivity(intent)
                Toast.makeText(this, "Move to Diary Fragment $d", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity()
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}