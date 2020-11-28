package com.example.batch3_assignment2

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kalkulator_b_b_i.*
import kotlinx.android.synthetic.main.activity_main.*

class KalkulatorBBI : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_b_b_i)

        val getData = intent.getParcelableExtra<modelForm>("data")

        textUsernameKal.text = "Welcome ${getData?.username}"
        textPasswordKal.text = "Your pasword is ${getData?.password}"

        btnHitungUmur.setOnClickListener {
            val movetoHitung = Intent(this, HitungUmur::class.java)
            startActivity(movetoHitung)
        }

        val JK: Spinner = findViewById(R.id.list_jenisKelamin)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.jenis_kelamin,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            JK.adapter = adapter
        }
        val spinner: Spinner = findViewById(R.id.list_jenisKelamin)
        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        btnCek.setOnClickListener {
            val kelamin = p0?.getItemAtPosition(p2).toString()
            val tinggi = edtTB.text.toString()
            val berat = edtBB.text.toString()
            val bb: Double?

            if (tinggi.toIntOrNull() != null) {

                when (kelamin) {
                    "Laki-laki" -> {
                        bb =
                            (tinggi.toInt() - 100) - ((tinggi.toInt() - 100) * (10 / 100)).toDouble()
                        AlertDialog.Builder(this).apply {
                            setTitle("Kalkulator BMI")
                            setMessage("Berat Badan anda adalah $berat dan berat badan ideal anda seharusnya $bb kg")
                            setPositiveButton("OK") { dialog, _ ->
                                Toast.makeText(applicationContext, "ilalliqa", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()
                            }
                            setNegativeButton("Back") { dialog, _ ->
                                Toast.makeText(
                                    applicationContext,
                                    "ma'assalamah",
                                    Toast.LENGTH_SHORT
                                ).show()
                                dialog.dismiss()
                            }.show()
                        }

                    }
                    "Perempuan" -> {
                        bb = (tinggi.toInt() - 100) - ((tinggi.toInt() - 100) * 0.15)
                        AlertDialog.Builder(this).apply {
                            setTitle("Kalkulator BMI")
                            setMessage("Berat Badan ideal anda $bb kg")
                            setPositiveButton("OK") { dialog, _ ->
                                Toast.makeText(applicationContext, "ilalliqa", Toast.LENGTH_SHORT)
                                    .show()
                                dialog.dismiss()
                            }
                            setNegativeButton("Back") { dialog, _ ->
                                Toast.makeText(
                                    applicationContext,
                                    "ma'assalamah",
                                    Toast.LENGTH_SHORT
                                ).show()
                                dialog.dismiss()
                            }.show()
                        }
                    }
                }

            }
        }

    }

}
