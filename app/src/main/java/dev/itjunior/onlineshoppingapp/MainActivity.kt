package dev.itjunior.onlineshoppingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openNewPageButton.setOnClickListener{
            Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show()
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

    }
}