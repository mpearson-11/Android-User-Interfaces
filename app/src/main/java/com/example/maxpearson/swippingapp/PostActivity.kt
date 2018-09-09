package com.example.maxpearson.swippingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val textView : TextView = findViewById(R.id.activityPostContent)
        val backToPostsButton : Button = findViewById(R.id.backToPostsButton)

        // Set Text for content and title for activity..
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val position = intent.getIntExtra("position", -1)

        setTitle(title)
        textView.setText(content)

        // Enable click for MainActivity Load..
        backToPostsButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("postPosition", position)
            startActivity(intent)
        }
    }
}
