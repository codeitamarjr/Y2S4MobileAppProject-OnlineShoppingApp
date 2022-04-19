package dev.itjunior.onlineshoppingapp

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import dev.itjunior.onlineshoppingapp.models.Post
import kotlinx.android.synthetic.main.activity_posts.*
import okhttp3.*
import java.io.IOException

class PostActivity: AppCompatActivity(R.layout.activity_posts) {

    private lateinit var client: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val client = OkHttpClient()
        Handler(Looper.getMainLooper()).postDelayed({
            makePostRequest()
        }, 5000)
    }

    fun makeUserRequest(){
        val url = "https://jsonplaceholder.typicode.com/users"
        val request = Request.Builder().url(url).build()

    }

    fun makePostRequest(){
        val url = "https://fakestoreapi.com/products"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e(POST_ACTIVITY_LOG_KEY,"response Failed: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val responseBody = response.body!!.string()
                    val posts = Gson().fromJson(responseBody, Array<Post>::class.java)
                    posts.forEach {
                        Log.i(POST_ACTIVITY_LOG_KEY,it.toString())}

                        //ui updates
                        Handler(Looper.getMainLooper()).post{
                            Toast.makeText(this@PostActivity,"Posts parsing completed", Toast.LENGTH_LONG).show()

                            loading_text.visibility = View.GONE
                            posts_recycler_view.visibility = View.VISIBLE
                            posts_recycler_view.layoutManager = LinearLayoutManager(this@PostActivity)
                            posts_recycler_view.adapter = PostAdapter(posts,this@PostActivity)


                    }
                    Log.i(POST_ACTIVITY_LOG_KEY,"response received: $responseBody")
                } else {
                    Log.e(POST_ACTIVITY_LOG_KEY,"response Failed: ${response.code}")

                }
            }

        })

    }

}

