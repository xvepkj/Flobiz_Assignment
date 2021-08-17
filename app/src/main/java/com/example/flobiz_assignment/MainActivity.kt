package com.example.flobiz_assignment

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.flobiz_assignment.adapter.ItemAdapter
import com.example.flobiz_assignment.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataSet= Datasource().loadItems()
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter= ItemAdapter(this,myDataSet)
        recyclerView.setHasFixedSize(true)
    }
    fun isAdCrossed(): Boolean {
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean("crossed",false)
    }
    fun crossIt(){
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putBoolean("crossed",true)
            apply()
        }
    }
}
