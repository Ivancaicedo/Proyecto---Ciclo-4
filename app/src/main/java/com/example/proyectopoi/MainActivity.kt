package com.example.proyectopoi

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopoi.utils.Utils
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var cityNames:  ArrayList<String> = ArrayList()
    var cityContact:  ArrayList<String> = ArrayList()
    var cityDescription:  ArrayList<String> = ArrayList()
    var cityImage: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        val LinearLayoutManager = LinearLayoutManager(applicationContext)

        recyclerView.layoutManager = LinearLayoutManager
        try{
            val obj = JSONObject(Utils(this).loadJsonFromAssets(applicationContext, "places.json"))
            val placesArray = obj.getJSONArray("places")
            for(i in 0 until placesArray.length()){
                var cityInfo = placesArray.getJSONObject(i)
                cityNames.add(cityInfo.getString("name"))
                cityContact.add(cityInfo.getString("contactInfo"))
                cityDescription.add(cityInfo.getString("description"))
                cityImage.add(cityInfo.getString("imgUrl"))
            }
        }catch (e:JSONException){
            e.printStackTrace()
        }

        val customAdapter = CustomAdapter(this@MainActivity, cityNames, cityContact, cityDescription, cityImage)
        recyclerView.adapter = customAdapter

    }
}