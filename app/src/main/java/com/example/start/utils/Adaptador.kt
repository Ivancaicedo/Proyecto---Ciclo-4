package com.example.start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.start.models.LugarItem
import com.squareup.picasso.Picasso

class CustomAdapter(
    private val onItemClicked:(LugarItem) -> Unit,
    private val lugarList:ArrayList<LugarItem>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_main5,parent,false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = lugarList[position]
        holder.itemView.setOnClickListener{onItemClicked(lugarList[position])}
        holder.bind(lugar)


    }

    override fun getItemCount(): Int {
        return lugarList.size
    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista) {

        var nombre: TextView = vista.findViewById(R.id.nombreV)
        var descripcion: TextView = vista.findViewById(R.id.descripcionV)
        var imagen: ImageView = vista.findViewById(R.id.imagenV)

        fun bind(lugar: LugarItem) {
            nombre.text = lugar.nombre
            descripcion.text = lugar.descripcion
            Picasso.get().load(lugar.imagen).into(imagen)
        }
    }
}