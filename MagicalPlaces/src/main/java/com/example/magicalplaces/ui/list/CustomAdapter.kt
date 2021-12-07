package com.example.start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.magicalplaces.R
import com.example.magicalplaces.models.LugarItem
import com.squareup.picasso.Picasso

class CustomAdapter(
    private val lugarList:ArrayList<LugarItem>,
    private val onItemClicked:(LugarItem) -> Unit
) : RecyclerView.Adapter<CustomAdapter.LugarViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view,parent,false)
        return LugarViewHolder(vista)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = lugarList[position]
        holder.itemView.setOnClickListener { onItemClicked(lugarList[position])}
        holder.bind(lugar)
    }

    override fun getItemCount(): Int = lugarList.size
    fun appendItems(newItems: ArrayList<LugarItem>) {
        lugarList.clear()
        lugarList.addAll(newItems)
        notifyDataSetChanged()
    }

    class LugarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nombre: TextView = itemView.findViewById(R.id.nombreV)
        private var descripcion: TextView = itemView.findViewById(R.id.descripcionV)
        private var imagen: ImageView = itemView.findViewById(R.id.imagenVD)

        fun bind(lugar: LugarItem) {
            nombre.text = lugar.nombre
            descripcion.text = lugar.descripcion
            Picasso.get().load(lugar.imagen).into(imagen)
        }
    }
}