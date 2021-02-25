package com.android.seedrextension.ui.slideshow

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.seedrextension.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
                ViewModelProvider(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        val web_torrent : WebView = root.findViewById(R.id.web_torrent)

        web_torrent.setWebViewClient(object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view:WebView, url:String):Boolean {
                var keyCode = null
                if (keyCode == KeyEvent.KEYCODE_BACK && web_torrent.canGoBack()) {
                    web_torrent.goBack()
                }
                    return false
            }
        })

        web_torrent.loadUrl("https://1337x.to")

        web_torrent.setScrollbarFadingEnabled(false);
        val newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0"

        web_torrent.evaluateJavascript("document.querySelector('meta[name=\"viewport\"]').setAttribute('content', 'width=1024px, initial-scale=' + (document.documentElement.clientWidth / 1024));", null);

        web_torrent.getSettings().setUserAgentString(newUA)

        web_torrent.getSettings().setJavaScriptEnabled(true);
        web_torrent.getSettings().setLoadWithOverviewMode(true);
        web_torrent.getSettings().setUseWideViewPort(true);

        web_torrent.getSettings().setSupportZoom(true);
        web_torrent.getSettings().setBuiltInZoomControls(true);
        web_torrent.getSettings().setDisplayZoomControls(false);

        if (web_torrent.canGoBack()) web_torrent.goBack()

        return root
    }

}