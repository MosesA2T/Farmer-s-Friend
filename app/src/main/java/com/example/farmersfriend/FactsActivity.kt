package com.example.farmersfriend

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class FactsActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts)

        webView = findViewById(R.id.wb_webView)

        webViewSetup()
    }

    private fun webViewSetup() {
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("https://www.mspca.org/pet_resources/interesting-facts-about-farm-animals/")
        }
    }
}