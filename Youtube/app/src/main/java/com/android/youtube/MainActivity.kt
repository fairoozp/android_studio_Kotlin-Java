package com.android.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    val youtube : WebView =findViewById(R.id.youtube)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        youtube.loadUrl("https://www.youtube.com/")
        youtube.settings.javaScriptEnabled=true
        youtube.settings.builtInZoomControls=true
        youtube.webChromeClient= WebChromeClient()
        youtube.webViewClient= WebViewClient()



    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode== KeyEvent.KEYCODE_BACK && youtube.canGoBack()){
            youtube.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}