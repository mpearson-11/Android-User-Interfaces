package com.example.maxpearson.swippingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        setTitle(intent.getStringExtra("title"))

    }
}
