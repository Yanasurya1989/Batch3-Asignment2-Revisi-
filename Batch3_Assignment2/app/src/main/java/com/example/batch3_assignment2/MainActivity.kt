package com.example.batch3_assignment2

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val login = modelForm(textUsernameMain.text.toString(), textPasswordMain.text.toString())

            if(textUsernameMain.text.toString() == "Yana" && textPasswordMain.text.toString() == "1234") {

                val move = Intent(this, KalkulatorBBI::class.java)
                move.putExtra("data", login)
                startActivity(move)
                finish()

            }else{
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}