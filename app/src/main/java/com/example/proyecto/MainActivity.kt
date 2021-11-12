package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)

        setTheme(R.style.Theme_Proyecto)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}