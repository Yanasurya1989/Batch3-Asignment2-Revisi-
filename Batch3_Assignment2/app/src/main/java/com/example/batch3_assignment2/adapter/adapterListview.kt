package com.example.batch3_assignment2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.batch3_assignment2.R
import com.example.batch3_assignment2.modelListview.classListview

class adapterListview(private val context: Context, private val  data: List<classListview>?) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.listitem, parent, false)

        var foto = view.findViewById<ImageView>(R.id.listImage)
        var mufrodats = view.findViewById<TextView>(R.id.txtMufrodats)
        var item = data?.get(position)

        foto.setImageResource(item?.image ?: 0)
        mufrodats.text = item?.mufrodats


        return view
    }

    override fun getItem(position: Int): Any {
        return data?.get(position) ?:0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = data?.size ?: 0

}
