package com.example.magicalplaces.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.magicalplaces.data.LugaresRepository
import com.example.magicalplaces.models.Lugar
import com.example.magicalplaces.models.LugarItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {
    private var lugarLoad: MutableLiveData<ArrayList<LugarItem>> = MutableLiveData()
    val onLugarLoaded: LiveData<ArrayList<LugarItem>> = lugarLoad

    private val repository = LugaresRepository()
    fun getLugaresFromServer(){
        GlobalScope.launch (Dispatchers.IO){
            lugarLoad.postValue(repository.getLugares())
        }
    }

    fun loadFromJson(lugaresString: InputStream?){
        val lugarString = lugaresString?.bufferedReader().use{it!!.readText()}
        val gson = Gson()
        lugarLoad.value = gson.fromJson(lugarString, Lugar::class.java)
    }
}