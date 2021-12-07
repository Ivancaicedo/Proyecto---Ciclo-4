package com.example.magicalplaces.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicalplaces.databinding.FragmentListBinding
import com.example.magicalplaces.models.LugarItem
import com.example.magicalplaces.ui.main.MainActivity
import com.example.start.CustomAdapter

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var lugarAdapter: CustomAdapter
    private var lugarList:ArrayList<LugarItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
//        lugarList = loadFromJson()
        listViewModel.getLugaresFromServer()
        listViewModel.onLugarLoaded.observe(viewLifecycleOwner, { result ->
            onLugarLoadedSubscribe(result)
        })

        lugarAdapter = CustomAdapter(lugarList,onItemClicked = { onLugarClicked(it)})

        listBinding.lista.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugarAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugarLoadedSubscribe(result: ArrayList<LugarItem>?) {
        result?.let { listLugares ->
            lugarAdapter.appendItems(listLugares)
        }
    }
    private fun onLugarClicked(lugar: LugarItem) {
        Log.d("nombre",lugar.nombre)
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))
    }
//
//    private fun loadFromJson(): ArrayList<LugarItem> {
//        val lugarString: String = context?.assets?.open("NuevaZelanda.json")?.bufferedReader().use { it!!.readText() }
//        val gson = Gson()
//        return gson.fromJson(lugarString, Lugar::class.java)
//    }

}
