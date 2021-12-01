package com.example.proyectopoi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class activity_detail: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avtivity_detail)

        supportActionBar?.hide()
    }
}