package com.example.flobiz_assignment

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.flobiz_assignment.adapter.ItemAdapter
import com.example.flobiz_assignment.data.Datasource
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var crossed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataSet= Datasource().loadItems()
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter= ItemAdapter(this,myDataSet)
        recyclerView.setHasFixedSize(true)
    }
    fun isAdCrossed(): Boolean {
        val ad = findViewById<MaterialCardView>(R.id.ad_card)
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val defaultValue = false
        return sharedPref.getBoolean("crossed",false)
    }
    fun crossIt(){
        val button = findViewById<FloatingActionButton>(R.id.cross_button)
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putBoolean("crossed",true)
            apply()
        }
    }
}
