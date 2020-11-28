package com.example.batch3_assignment2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.batch3_assignment2.adapter.adapterRecyclerview
import com.example.batch3_assignment2.modelListview.classListview
import kotlinx.android.synthetic.main.activity_listview.*
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlinx.android.synthetic.main.detil_mufrodats.*
import kotlinx.android.synthetic.main.listitem.*

class Recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val listMufrodats = ArrayList<classListview>()
        listMufrodats.add(classListview("Thairah", "Pesawat", "At Thairatu kabiratun", R.drawable.thairah))
        listMufrodats.add(classListview("Darrajah", "Sepeda", "Ad darajatu katsirotun", R.drawable.darrajah))
        listMufrodats.add(classListview("Sayyarah", "Mobil", "As Sayyaratu jamilatun", R.drawable.sayyarah))

            listRecyclerview.adapter = adapterRecyclerview(this, listMufrodats, object : adapterRecyclerview.OnClickListener{
            override fun detailData(item: classListview?){
                Dialog(this@Recyclerview).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detil_mufrodats)

                    val foto = this.findViewById<ImageView>(R.id.foto)
                    val mufrodats = this.findViewById<TextView>(R.id.textMufrodats)
                    val makna = this.findViewById<TextView>(R.id.textMakna)
                    val mitsl = this.findViewById<TextView>(R.id.textMitsl)

                    foto.setImageResource(item?.image ?: 0)
                    mufrodats.text = "Nama : ${item?.mufrodats}"
                    makna.text = "Makna : ${item?.makna}"
                    mitsl.text = "Mitsl : ${item?.mitsl}"

                    btnClose.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}