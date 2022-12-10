package com.shristi.shristi_resume
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        webView = findViewById(R.id.web_view)
        webView.webViewClient = WebViewClient()

        val urlToBeLoaded = intent.getStringExtra("url")
        webView.loadUrl(urlToBeLoaded!!)

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}