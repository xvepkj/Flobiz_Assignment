package com.example.flobiz_assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flobiz_assignment.MainActivity
import com.example.flobiz_assignment.R
import com.example.flobiz_assignment.model.ListItem
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ItemAdapter(private val context: Context,
                  private val dataset : List<ListItem>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ItemViewHolderA(private val view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }
    class ItemViewHolderB(private val view: View) : RecyclerView.ViewHolder(view){
        val ad : MaterialCardView = view.findViewById(R.id.ad_card)
        val crossButton : FloatingActionButton = view.findViewById(R.id.cross_button)
    }
    override fun getItemViewType(position: Int): Int {
        if(position == dataset.size-1)
            return 1
        return 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0) {
            val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
            return ItemViewHolderA(adapterLayout)
        }
        else {
            val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.myad_view, parent, false)
            return ItemViewHolderB(adapterLayout)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position != dataset.size-1) {
            val item = dataset[position]
            (holder as ItemViewHolderA).textView.text = context.resources.getString(item.stringResourceId)+" "+(position+1)
            holder.imageView.setImageResource(item.imageResourceId)
        }
        else {
            val crossButtonValue = (context as MainActivity).isAdCrossed()
            if(crossButtonValue)
                (holder as ItemViewHolderB).ad.visibility = View.GONE
            (holder as ItemViewHolderB).crossButton.setOnClickListener{
                holder.ad.visibility = View.GONE
                (context as MainActivity).crossIt()
            }
        }
    }

    override fun getItemCount()= dataset.size

}
