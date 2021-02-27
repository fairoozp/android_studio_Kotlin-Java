package com.android.messenger

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    lateinit var phone : EditText
    lateinit var message : EditText
    lateinit var send : ImageButton
    lateinit var clear :ImageButton

    lateinit var number : String
    lateinit var content : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        phone = findViewById(R.id.phone)
        message = findViewById(R.id.message)
        send = findViewById(R.id.send)
        clear = findViewById(R.id.clear)


        send.setOnClickListener {
            number=phone.text.toString()
            content=message.text.toString()
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(number, null, content, null, null)
            Toast.makeText(this, "Message Send Successfully", Toast.LENGTH_SHORT).show()
            message.setText("")
            sendsms()
        }

        clear.setOnClickListener {
            message.setText("")
            Toast.makeText(this, "Message Cleared", Toast.LENGTH_SHORT).show()
        }


    }

    private fun sendsms() {
        number=phone.text.toString()
        content=phone.text.toString()
        if ((ContextCompat.checkSelfPermission(this,
                        Manifest.permission.SEND_SMS) !== PackageManager.PERMISSION_GRANTED))
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.SEND_SMS))
            {}
            else
            {
                ActivityCompat.requestPermissions(this,
                        arrayOf<String>(Manifest.permission.SEND_SMS),
                        MY_PERMISSIONS_REQUEST_SEND_SMS)
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_SEND_SMS -> {
                if ((grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(number, null, content, null, null)
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show()
                    return
                }
            }
        }
    }
    companion object {
        private val MY_PERMISSIONS_REQUEST_SEND_SMS = 1
    }
}
