package com.example.maxpearson.swippingapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SnapHelper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.maxpearson.swippingapp.models.Post

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.post_item.view.*

class MainActivity : AppCompatActivity() {
    val posts : ArrayList<Post> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fillPosts()


        val adapter : SwipeAdapter = SwipeAdapter(posts, applicationContext)
        recyclerView.adapter = adapter

        val snapHelper : SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    fun fillPosts() {
        for (i in 1..50) {
            posts.add(Post("Hello: ${i}"))
        }
    }
}
