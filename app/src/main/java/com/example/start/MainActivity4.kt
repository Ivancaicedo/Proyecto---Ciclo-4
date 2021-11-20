package com.example.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity4 : AppCompatActivity() , OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        //    === === <-Navegar En Activitys-> === ===
        val imageButton6=findViewById<ImageView>(R.id.imageButton6)
        imageButton6.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        createFragment()
    }

    //    === === <-Generar Mapas-> === ===
    private lateinit var map: GoogleMap
    private fun createFragment() {
        val mapFragment=supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }
    private fun createMarker(){
        val coordenadas = LatLng(-44.64185078848542, 167.89896683992316)
        val marker = MarkerOptions().position(coordenadas)
        map.addMarker(marker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,12.8f),3000,null)

    }
}