package com.example.farmersfriend

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FoodActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        webView = findViewById(R.id.wb_webView)

        webViewSetup()
    }

    private fun webViewSetup() {
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("https://en.wikipedia.org/wiki/Animal_feed#:~:text=It%20includes%20hay%2C%20straw%2C%20silage,source%20of%20animal%20feed%20globally.")
        }
    }
}
