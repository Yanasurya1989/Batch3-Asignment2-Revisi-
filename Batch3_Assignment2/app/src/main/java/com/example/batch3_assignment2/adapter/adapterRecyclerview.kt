package com.example.batch3_assignment2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.batch3_assignment2.R
import com.example.batch3_assignment2.modelListview.classListview

class adapterRecyclerview (
    private var contex: Context,
    private var data: List<classListview>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<adapterRecyclerview.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data?.get(position)
        holder.image.setImageResource(item?.image ?:0)
        holder.mufrodats.text = item?.mufrodats

        holder.view.setOnClickListener{
            itemClick.detailData(item)
        }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        var image = view.findViewById<ImageView>(R.id.listImage)
        var mufrodats = view.findViewById<TextView>(R.id.txtMufrodats)

    }

    interface OnClickListener {
        fun detailData(item: classListview?)
    }
}