package com.example.batch3_assignment2

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.batch3_assignment2.adapter.adapterListview
import com.example.batch3_assignment2.modelListview.classListview
import kotlinx.android.synthetic.main.activity_listview.*
import kotlinx.android.synthetic.main.detil_mufrodats.*
import kotlinx.android.synthetic.main.listitem.*

class ListviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val listMufrodats = ArrayList<classListview>()
        listMufrodats.add(classListview("Baitun", "Rumah", "Hadza Baitun kabbirun", R.drawable.bs))
        listMufrodats.add(classListview("Baabun", "Pintu", "Hadza Baabun", R.drawable.bs))
        listMufrodats.add(classListview("Samakun", "Ikan", "Tilka samakun", R.drawable.bs))
        listMufrodats.add(classListview("Masjidun", "Masjid", "Dzalika Masjidun", R.drawable.bs))

        val adapter = adapterListview(this, listMufrodats)
        listview.adapter = adapter

        listview.setOnItemClickListener { parent, view, position, id ->
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.detil_mufrodats)

                val image = this.findViewById<ImageView>(R.id.foto)
                val mufrodats = this.findViewById<TextView>(R.id.textMufrodats)
                val makna = this.findViewById<TextView>(R.id.textMakna)
                val mitsl = this.findViewById<TextView>(R.id.textMitsl)

                val item = listMufrodats.get(position)

                image.setImageResource(item.image)
                mufrodats.text = "Mufrodats : ${item.mufrodats}"
                makna.text = "Makna : ${item.makna}"
                mitsl.text = "Mitsl : ${item.mitsl}"

                btnClose.setOnClickListener {
                    this.dismiss()
                }
                btn_rcylerview.setOnClickListener {
                    val intent = Intent(this@ListviewActivity, Recyclerview::class.java)
                    startActivity(intent)
                }
            }.show()
        }
    }
}