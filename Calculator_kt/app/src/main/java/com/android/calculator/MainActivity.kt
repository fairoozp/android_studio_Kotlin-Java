package com.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var i :Float=0f
    var t :Float=0f
    var op : Int=0


    lateinit var result: TextView
    lateinit var number:TextView
    private lateinit var b1:Button
    private lateinit var b2:Button
    private lateinit var b3:Button
    private lateinit var b4:Button
    private lateinit var b5:Button
    private lateinit var b6:Button
    private lateinit var b7:Button
    private lateinit var b8:Button
    private lateinit var b9:Button
    private lateinit var b0:Button
    private lateinit var bd:Button
    private lateinit var bs:Button
    private lateinit var bc:Button
    private lateinit var bp:Button
    private lateinit var bm:Button
    private lateinit var bml:Button
    private lateinit var bdv:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)
        b3=findViewById(R.id.b3)
        b4=findViewById(R.id.b4)
        b5=findViewById(R.id.b5)
        b6=findViewById(R.id.b6)
        b7=findViewById(R.id.b7)
        b8=findViewById(R.id.b8)
        b9=findViewById(R.id.b9)
        b0=findViewById(R.id.b0)
        bd=findViewById(R.id.bd)
        bs=findViewById(R.id.bs)
        bp=findViewById(R.id.bp)
        bm=findViewById(R.id.bm)
        bml=findViewById(R.id.bml)
        bdv=findViewById(R.id.bdv)
        bc=findViewById(R.id.bc)

        b1.setOnClickListener {
            i=i*10+1
            number.append("1")
        }
        b2.setOnClickListener {
            i=i*10+2
            number.append("2")
        }
        b3.setOnClickListener {
            i=i*10+3
            number.append("3")
        }
        b4.setOnClickListener {
            i=i*10+4
            number.append("4")
        }
        b5.setOnClickListener {
            i=i*10+5
            number.append("5")
        }
        b6.setOnClickListener {
            i=i*10+6
            number.append("6")
        }
        b7.setOnClickListener {
            i=i*10+7
            number.append("7")
        }
        b8.setOnClickListener {
            i=i*10+8
            number.append("8")
        }
        b9.setOnClickListener {
            i=i*10+9
            number.append("9")
        }
        b0.setOnClickListener {
            i=i*10+0
            number.append("0")
        }
        bd.setOnClickListener {
            i= (i*10+.0).toFloat()
            number.append(".")
        }
        bm.setOnClickListener {
            t -= i
            i= 0F
            number.append("-")
        }
        bml.setOnClickListener {
            t *= i
            i= 0F
            number.append("*")
        }
        bdv.setOnClickListener {
            t += i
            i= 0F
            number.append("/")
        }
        bp.setOnClickListener {
            number.append("+")
            if (op==0) {
                t=i
                i=0f
                op=1
            }
            else if (op==1){
                t+=1
                i=0f
                op=1
            }


        }


        bs.setOnClickListener {
            result.text = t.toString()
        }

        fun calc (v: View)
        {


            }

        }

    }