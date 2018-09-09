package com.example.maxpearson.swippingapp

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import kotlinx.android.synthetic.main.post_item.view.*
import com.example.maxpearson.swippingapp.models.*
import android.view.*
import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.graphics.BitmapFactory
import android.os.Environment
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.MemoryPolicy

class PostActivityIntent(val title : String, val content: String, val position: Int) {
    fun createIntent(intent: Intent) : Intent {
        intent.putExtra("title", title)
        intent.putExtra("content", content)
        intent.putExtra("position", position)
        return intent
    }
}

class SwipeAdapter(val posts : ArrayList<Post>, val context : Context) : RecyclerView.Adapter<SwipeAdapter.SwipeViewHolder>(), View.OnClickListener {
    override fun onClick(parent: View) {
    }

    fun startActivity(parent: View, position: Int) {
        // Create Intent for PostActivity to send data..
        val title = parent.postItemTitle.text.toString()
        val content = parent.postItemContent.text.toString()

        // Intent data for PostActivity (loading content and title)
        val intent = Intent(context, PostActivity::class.java)
        val mainActivityIntent = PostActivityIntent(title, content, position)
        val mainIntent = mainActivityIntent.createIntent(intent)

        // Start PostActivity
        context.startActivity(mainIntent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return SwipeViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: SwipeViewHolder, index: Int) {
        // Retrieve post by index....
        val post = posts.get(index)

        // ViewHolder content...
        holder.titleText.text = post.title
        holder.contentText.text = post.content

        // Set Clicklistener...
        holder.contentText.setOnClickListener { startActivity(holder.itemView, index) }

        Picasso.get()
                .load(post.image)
                .resize(100, 100)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(holder.imageView)
    }

    class SwipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentText : TextView = view.postItemContent
        val titleText : TextView = view.postItemTitle
        val imageView : ImageView = view.imageView
    }
}