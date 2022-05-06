package dev.itjunior.onlineshoppingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openNewPageButton.setOnClickListener{
            Toast.makeText(this,"Loading products...",Toast.LENGTH_LONG).show()
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

        mensButton.setOnClickListener{
            Toast.makeText(this,"Loading category men's...",Toast.LENGTH_LONG).show()
            val intent = Intent(this, PostActivityCategory::class.java)
            startActivity(intent)
        }

        val buttonClick = findViewById<Button>(R.id.about)
        buttonClick.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}