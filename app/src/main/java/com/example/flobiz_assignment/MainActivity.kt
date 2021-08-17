package com.example.flobiz_assignment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.flobiz_assignment.adapter.ItemAdapter
import com.example.flobiz_assignment.data.Datasource
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataSet= Datasource().loadItems()
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter= ItemAdapter(this,myDataSet)
        recyclerView.setHasFixedSize(true)
        val ad = findViewById<MaterialCardView>(R.id.ad_card)
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        val defaultValue = false
        val value = sharedPref.getBoolean("crossed",false)
        if(value)
            ad.visibility = View.GONE
        val button = findViewById<FloatingActionButton>(R.id.cross_button)
        button.setOnClickListener{
            ad.visibility = View.GONE
            val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean("crossed",true)
                apply()
            }
        }
    }
}