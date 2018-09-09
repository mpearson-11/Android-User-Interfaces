package com.example.maxpearson.swippingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SnapHelper
import com.example.maxpearson.swippingapp.models.Post
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

fun fillPosts() : ArrayList<Post> {
    val posts : ArrayList<Post> = ArrayList()

    for (i in 1..50) {
        val imageNumber = ((Math.random() * 150) * i + 25)
        val index = i + 10
        posts.add(Post("" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                " Proin sagittis nisl rhoncus mattis rhoncus." +
                " Commodo viverra maecenas accumsan lacus vel facilisis volutpat est." +
                " Egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate." +
                " Dignissim suspendisse in est ante." +
                " Elementum integer enim neque volutpat ac tincidunt." +
                " In nulla posuere sollicitudin aliquam ultrices sagittis orci." +
                " Proin sagittis nisl rhoncus mattis rhoncus." +
                " Tempor orci eu lobortis elementum nibh." +
                " At lectus urna duis convallis convallis tellus." +
                " Convallis posuere morbi leo urna molestie at." +
                " Laoreet non curabitur gravida arcu ac. Porttitor leo a diam sollicitudin tempor id eu nisl." +
                " Duis convallis convallis tellus id interdum velit." +
                " Morbi blandit cursus risus at ultrices mi tempus imperdiet." +
                " Mi tempus imperdiet nulla malesuada pellentesque." +
                " Rutrum quisque non tellus orci ac auctor augue." +
                " Nibh sit amet commodo nulla facilisi nullam vehicula ipsum.\n" +
                "\n" +
                " Sit amet volutpat consequat mauris. Morbi tristique senectus et netus et malesuada fames ac." +
                " Facilisi cras fermentum odio eu feugiat pretium nibh ipsum." +
                " Morbi tristique senectus et netus et malesuada." +
                " Amet risus nullam eget felis. Mauris pharetra et ultrices neque ornare aenean euismod elementum nisi." +
                " Lobortis feugiat vivamus at augue eget arcu." +
                " In fermentum et sollicitudin ac orci phasellus egestas." +
                " Massa vitae tortor condimentum lacinia quis. Quam quisque id diam vel" +
                " Eget velit aliquet sagittis id consectetur purus ut." +
                " Eu non diam phasellus vestibulum lorem sed." +
                " A pellentesque sit amet porttitor eget dolor." +
                "\n", "Post: ${i}", "http://i.imgur.com/DvpvklR.png"))
    }
    return posts
}

class MainActivity : AppCompatActivity() {
    val posts : ArrayList<Post> = fillPosts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fillPosts()

        val adapter = SwipeAdapter(posts, applicationContext)
        recyclerView.adapter = adapter

        val snapHelper : SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        val intentPosition = intent.getIntExtra("postPosition", -1)

        if (intentPosition >= 0) {
            recyclerView.scrollToPosition(intentPosition)
        }
    }
}
