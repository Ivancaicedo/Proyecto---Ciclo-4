package com.example.magicalplaces.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicalplaces.databinding.FragmentListBinding
import com.example.magicalplaces.main.MainActivity
import com.example.magicalplaces.models.Lugar
import com.example.magicalplaces.models.LugarItem
import com.example.start.CustomAdapter
import com.google.gson.Gson

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var lugarAdapter: CustomAdapter
    private lateinit var lugarList:ArrayList<LugarItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        lugarList = loadFromJson()
        lugarAdapter = CustomAdapter(lugarList,onItemClicked = { onLugarClicked(it)})

        listBinding.lista.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugarAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugarClicked(lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))
    }

    private fun loadFromJson(): ArrayList<LugarItem> {
        val lugarString: String = context?.assets?.open("NuevaZelanda.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        return gson.fromJson(lugarString, Lugar::class.java)
    }

}
