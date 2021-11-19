package com.example.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu;
import android.view.View;
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        setTheme(R.style.ThemeSTART)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sirio=findViewById<RelativeLayout>(R.id.layoutsirio)
        sirio.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }


    }

}