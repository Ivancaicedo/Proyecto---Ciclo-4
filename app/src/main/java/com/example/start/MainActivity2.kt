package com.example.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity2 : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val imageButton4=findViewById<ImageView>(R.id.imageButton4)
        imageButton4.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        createFragment()
    }

    private fun createFragment() {
            val mapFragment=supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
            mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }
    private fun createMarker(){
        val coordenadas = LatLng(-37.85783013651075, 175.68048688969265)
        val marker = MarkerOptions().position(coordenadas)
        map.addMarker(marker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,17f),2000,null)

    }
}


