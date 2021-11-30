package com.example.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.start.models.Lugar
import com.example.start.models.LugarItem
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var lugarList:ArrayList<LugarItem>

//    private var ifFragmentOneLoaded = true;
//    private val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ThemeSTART)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lugarList = loadFromJson()
        newRecyclerView = findViewById(R.id.lista)

        newRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CustomAdapter(onItemClicked = { onLugarClicked(it) }, lugarList)
            setHasFixedSize(false)
        }

    }

    private fun onLugarClicked(lugar: LugarItem) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("lugar",lugar)
        startActivity(intent)
    }
    private fun loadFromJson(): ArrayList<LugarItem> {
        val lugarString: String = applicationContext.assets.open("NuevaZelanda.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val listaLugares = gson.fromJson(lugarString, Lugar::class.java)
        return listaLugares
    }

//    val change = findViewById<Button>(R.id.btn_change)
//        showFragmentOne()
//        change.setOnClickListener {
//            if (ifFragmentOneLoaded) {
//                showFragmentTwo()
//            }
//            else {
//                showFragmentOne()
//            }
//        }

//        var lugares = ArrayList<LugarItem>()
//
//        lugares.add(LugarItem("Hobbbbiton", "lugar de los hobits", R.drawable.hobiton))
//        lugares.add(LugarItem("MIlfor", "sdfgsfghsfghs",R.drawable.cathedralcove))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("Hobbbbiton", "lugar de los hobits", R.drawable.hobiton))
//        lugares.add(LugarItem("MIlfor", "sdfgsfghsfghs",R.drawable.cathedralcove))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        lugares.add(LugarItem("dfghjdgjddgj", "d34563456sdfgdgjdgjsfghsfghs", R.drawable.milford))
//        println(lugares)
//
//



//        val sirio=findViewById<RelativeLayout>(R.id.layoutsirio)
//        sirio.setOnClickListener {
//            startActivity(Intent(this, MainActivity2::class.java))
//        }
//
//        val tongariro=findViewById<RelativeLayout>(R.id.relativeLayout2)
//        tongariro.setOnClickListener {
//            startActivity(Intent(this, MainActivity3::class.java))
//        }
//
//        val milford=findViewById<RelativeLayout>(R.id.Milford)
//        milford.setOnClickListener {
//            startActivity(Intent(this, MainActivity4::class.java))
//        }

//    private fun showFragmentOne(){
//        val transaction = manager.beginTransaction()
//        val fragment = FragmentOne()
//        transaction.replace(R.id.fragment_container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//        ifFragmentOneLoaded = true
//    }
//    private fun showFragmentTwo(){
//        val transaction = manager.beginTransaction()
//        val fragment = FragmentTwo()
//        transaction.replace(R.id.fragment_container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//        ifFragmentOneLoaded = false
//    }

}







