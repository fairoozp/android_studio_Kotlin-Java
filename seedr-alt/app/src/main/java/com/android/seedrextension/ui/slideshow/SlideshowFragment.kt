package com.android.seedrextension.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
        web_torrent.loadUrl("https://1337x.to")
        web_torrent.getSettings().setJavaScriptEnabled(true);
        web_torrent.getSettings().setLoadWithOverviewMode(true);
        web_torrent.getSettings().setUseWideViewPort(true);

        web_torrent.getSettings().setSupportZoom(true);
        web_torrent.getSettings().setBuiltInZoomControls(true);
        web_torrent.getSettings().setDisplayZoomControls(false);

        web_torrent.setScrollbarFadingEnabled(false);
        val newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0"
        web_torrent.getSettings().setUserAgentString(newUA)

        if (web_torrent.canGoBack()) web_torrent.goBack()

        return root
    }
}