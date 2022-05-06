package dev.itjunior.onlineshoppingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.itjunior.onlineshoppingapp.models.Post

class PostAdapter(private val posts:Array<Post>, private val context: Context): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.template_post_item, parent, false) // inflate layout
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //postContent.text = context.getString(R.string.template_post_content, position.toFloat())
        val currentPost = posts[position]
        val postBody = holder.itemView.findViewById<TextView>(R.id.post_title)
        val postPrice = holder.itemView.findViewById<TextView>(R.id.post_price)
        val postTitle = holder.itemView.findViewById<TextView>(R.id.post_description)
        val postCategory = holder.itemView.findViewById<TextView>(R.id.post_category)
        val postImg = holder.itemView.findViewById<TextView>(R.id.post_img)
        postTitle.text = currentPost.title
        postPrice.text = currentPost.price.toString()
        postBody.text = currentPost.description
        postCategory.text = currentPost.category
        postImg.text = currentPost.image
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}

