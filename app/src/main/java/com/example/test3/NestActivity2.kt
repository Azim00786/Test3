package com.example.test3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NestActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nest2)



        val name = intent.extras?.getString("name")
        val name1 = findViewById<TextView>(R.id.textnext)
        name1.text = name

        val derc = intent.extras?.getString("derc")
        val dercrip = findViewById<TextView>(R.id.description2)
        dercrip.text = derc

//        val hello = intent.extras?.getString("name")
//        val image = findViewById<ImageView>(R.id.image1)
//        if (hello != null) {
//            image.setImageResource(hello.toInt())
//        }
    }
}