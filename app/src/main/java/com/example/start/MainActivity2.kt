//package com.example.start
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ImageButton
//import android.widget.ImageView
//import android.widget.RelativeLayout
//import com.example.start.models.LugarItem
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//
//class MainActivity2 : AppCompatActivity() , OnMapReadyCallback {
//
//    private lateinit var detalleBinding: ActivityDetalleBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
//        setContentView(detalleBinding.root)
//
//        val lugar: LugarItem = intent.extras?.getSerializable("lugar") as LugarItem
//
//        with(detalleBinding){
//            nombre.text = lugar.nombre
//            descripcion.text = lugar.descripcion
//            descripcionLarga.text = lugar.descripcionLarga
//            Picasso.get().load(lugar.imagen).into(pictureImageView)
//        }
//        createFragment()
//    }
//
////    === === <-Generar Mapas-> === ===
//    private lateinit var map:GoogleMap
//    private fun createFragment() {
//            val mapFragment=supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
//            mapFragment.getMapAsync(this)
//    }
//    override fun onMapReady(googleMap: GoogleMap) {
//        map = googleMap
//        createMarker()
//    }
//    private fun createMarker(){
//        val coordenadas = LatLng(-37.85783013651075, 175.68048688969265)
//        val marker = MarkerOptions().position(coordenadas)
//        map.addMarker(marker)
//        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,17f),3000,null)
//
//    }
//}


