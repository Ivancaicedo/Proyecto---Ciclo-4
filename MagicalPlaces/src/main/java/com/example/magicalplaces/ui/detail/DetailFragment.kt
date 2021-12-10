package com.example.magicalplaces.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.magicalplaces.R
import com.example.magicalplaces.databinding.FragmentDetailBinding
import com.example.magicalplaces.ui.main.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        with(detailBinding) {
            nombreV.text = lugar.nombre
            descripcionLargaV.text = lugar.descripcionLarga
            Picasso.get().load(lugar.imagen).into(imagenVD)
        }
    }
    private val callback = OnMapReadyCallback { googleMap ->
        val lugar = args.lugar
        val hobbiton = LatLng(lugar.latitud.toDouble(), lugar.longitud.toDouble())
        googleMap.addMarker(MarkerOptions().position(hobbiton).title(lugar.nombre))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(hobbiton,13.5f),2300,null)
    }
}