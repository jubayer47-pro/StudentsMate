package com.studentsmate.app

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://jubayer47-pro.github.io/StudentsMate/")

        val adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-7009578840220882/9849262368"

        layout.addView(
            webView,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        layout.addView(adView)

        setContentView(layout)

        adView.loadAd(AdRequest.Builder().build())
    }
}
