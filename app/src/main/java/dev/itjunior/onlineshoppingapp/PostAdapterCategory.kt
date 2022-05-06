package dev.itjunior.onlineshoppingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import dev.itjunior.onlineshoppingapp.models.Post

class PostAdapterCategory(private val posts:Array<Post>, private val context: Context): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.template_post_item, parent, false) // inflate layout
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val currentPost = posts[position]
        val postBody = holder.itemView.findViewById<TextView>(R.id.post_title)
        val postPrice = holder.itemView.findViewById<TextView>(R.id.post_price)
        val postTitle = holder.itemView.findViewById<TextView>(R.id.post_description)
        val postCategory = holder.itemView.findViewById<TextView>(R.id.post_category)
        postTitle.text = currentPost.title
        postPrice.text = currentPost.price.toString()
        postBody.text = currentPost.description
        postCategory.text = currentPost.category

        val imageView = holder.itemView.findViewById<ImageView>(R.id.productImage)
        imageView.setImageDrawable(
            AppCompatResources.getDrawable(
                context,
                R.drawable.default_image
            )
        )
        val imgUrl = currentPost.image
        Picasso.get()
            .load(imgUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(imageView)
    }

    override fun getItemCount(): Int {
        return 4
    }
}

