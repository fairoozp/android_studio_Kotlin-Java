package com.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var i: Float = 0f
    private var t: Float = 0f
    private var op: Int = 0
    private var s: Float = 0f
    private var j:String=""

    private lateinit var result: TextView
    private lateinit var number: TextView
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var b0: Button
    private lateinit var bd: Button
    private lateinit var bs: Button
    private lateinit var bc: Button
    private lateinit var bp: Button
    private lateinit var bm: Button
    private lateinit var bml: Button
    private lateinit var bdv: Button
    private lateinit var neg: Button
    private lateinit var del: Button
    private lateinit var per: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        per = findViewById(R.id.per)
        del = findViewById(R.id.del)
        neg = findViewById(R.id.neg)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        b0 = findViewById(R.id.b0)
        bd = findViewById(R.id.bd)
        bs = findViewById(R.id.bs)
        bp = findViewById(R.id.bp)
        bm = findViewById(R.id.bm)
        bml = findViewById(R.id.bml)
        bdv = findViewById(R.id.bdv)
        bc = findViewById(R.id.bc)
        number = findViewById(R.id.number)
        result = findViewById(R.id.result)

        b1.setOnClickListener {
            j += 1
            i=j.toFloat()
            number.append("1")
        }
        b2.setOnClickListener {
            j += 2
            i=j.toFloat()
            number.append("2")
        }
        b3.setOnClickListener {
            j += 3
            i=j.toFloat()
            number.append("3")
        }
        b4.setOnClickListener {
            j += 4
            i=j.toFloat()
            number.append("4")
        }
        b5.setOnClickListener {
            j += 5
            i=j.toFloat()
            number.append("5")
        }
        b6.setOnClickListener {
            j += 6
            i=j.toFloat()
            number.append("6")
        }
        b7.setOnClickListener {
            j += 7
            i=j.toFloat()
            number.append("7")
        }
        b8.setOnClickListener {
            j += 8
            i=j.toFloat()
            number.append("8")
        }
        b9.setOnClickListener {
            j += 9
            i=j.toFloat()
            number.append("9")
        }
        b0.setOnClickListener {
            j += 0
            i=j.toFloat()
            number.append("0")
        }
        bd.setOnClickListener {
            j += "."
            i=j.toFloat()
            number.append(".")
        }

        bp.setOnClickListener {
            number.append("+")
            j = ""
            when (op) {
                0 -> {
                    t = i
                    i = 0f
                    op = 1
                }
                1 -> {
                    t += i
                    i = 0f
                    op = 1
                }
                2 -> {
                    t -= i
                    i = 0f
                    op = 1
                }
                3 -> {
                    t *= i
                    i = 0f
                    op = 1
                }
                4 -> {
                    t /= i
                    i = 0f
                    op = 1
                }
            }

            bm.setOnClickListener {
                number.append("-")
                j = ""
                when (op) {
                    0 -> {
                        t = i
                        i = 0f
                        op = 2
                    }
                    1 -> {
                        t += i
                        i = 0f
                        op = 2
                    }
                    2 -> {
                        t -= i
                        i = 0f
                        op = 2
                    }
                    3 -> {
                        t *= i
                        i = 0f
                        op = 2
                    }
                    4 -> {
                        t /= i
                        i = 0f
                        op = 2
                    }
                }
            }

            bml.setOnClickListener {
                number.append("*")
                j = ""
                when (op) {
                    0 -> {
                        t = i
                        i = 0f
                        op = 3
                    }
                    1 -> {
                        t += i
                        i = 0f
                        op = 3
                    }
                    2 -> {
                        t -= i
                        i = 0f
                        op = 3
                    }
                    3 -> {
                        t *= i
                        i = 0f
                        op = 3
                    }
                    4 -> {
                        t /= i
                        i = 0f
                        op = 3
                    }
                }
            }

            bdv.setOnClickListener {
                number.append("/")
                j = ""
                when (op) {
                    0 -> {
                        t = i
                        i = 0f
                        op = 4
                    }
                    1 -> {
                        t += i
                        i = 0f
                        op = 4
                    }
                    2 -> {
                        t -= i
                        i = 0f
                        op = 4
                    }
                    3 -> {
                        t *= i
                        i = 0f
                        op = 4
                    }
                    4 -> {
                        t /= i
                        i = 0f
                        op = 4
                    }
                }
            }
        }


        bs.setOnClickListener {
            when (op) {
                0 -> {
                    s = i
                    op = 0
                }
                1 -> {
                    s = t + i
                    op = 0
                }
                2 -> {
                    s = t - i
                    op = 0
                }
                3 -> {
                    s = t * i
                    op = 0
                }
                4 -> {
                    s = t / i
                    op = 0
                }
                5 -> {
                    s=t%i
                    op=0
                    i=0f
                    t=0f
                }
            }
            result.text = s.toString()
        }
        neg.setOnClickListener {
            i *= -1
            j=i.toString()
            number.append("(-1)")
        }
        del.setOnClickListener {
            if(j != "") {
                j=j.dropLast(1)
                i=j.toFloat()
                number.text=j
            }
        }
        per.setOnClickListener {
            number.append("%")
            op=5
            t=i
            i= 0F
        }
        bc.setOnClickListener {
            result.text = ""
            number.text = ""
            i = 0f
            t = 0f
            op = 0
            j = ""

        }
    }

}
