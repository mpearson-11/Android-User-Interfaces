package com.example.maxpearson.swippingapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import kotlinx.android.synthetic.main.post_item.view.*
import com.example.maxpearson.swippingapp.models.*
import android.util.Log
import android.view.*
import android.widget.Toast
import android.content.Context
import android.content.Intent

class SwipeAdapter(val posts : ArrayList<Post>, val context : Context) : RecyclerView.Adapter<SwipeAdapter.SwipeViewHolder>(), View.OnClickListener {
    override fun onClick(p0: View) {
        val intent = Intent(context, PostActivity::class.java)
        intent.putExtra("title", p0.postItemText.text.toString())
        context.startActivity(intent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return SwipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: SwipeViewHolder, position: Int) {
        val post = posts[position]
        holder.postText.text = post.text
        holder.postCard.setOnClickListener { onClick(it) }
    }

    class SwipeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val postText : TextView = itemview.postItemText
        val postCard : CardView = itemview.postItemCardView
    }
}