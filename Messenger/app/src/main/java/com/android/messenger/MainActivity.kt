package com.android.messenger


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    private lateinit var phone : EditText
    private lateinit var message : EditText
    private lateinit var send : ImageButton
    private lateinit var clear : ImageButton
    private lateinit var call : ImageButton

    private lateinit var number : String
    private lateinit var content : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        phone = findViewById(R.id.phone)
        message = findViewById(R.id.message)
        send = findViewById(R.id.send)
        clear = findViewById(R.id.clear)
        call = findViewById(R.id.call)


        send.setOnClickListener {
            number=phone.text.toString()
            content=message.text.toString()
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(number, null, content, null, null)
            Toast.makeText(this, "Message Send Successfully", Toast.LENGTH_SHORT).show()
            message.setText("")
        }

        clear.setOnClickListener {
            message.setText("")
            Toast.makeText(this, "Message Cleared", Toast.LENGTH_SHORT).show()
        }

        call.setOnClickListener {
            number=phone.text.toString()
            val dialIntent = Intent(Intent.ACTION_CALL)
            dialIntent.data = Uri.parse("tel:$number")
            startActivity(dialIntent)
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show()
        }


    }
}
