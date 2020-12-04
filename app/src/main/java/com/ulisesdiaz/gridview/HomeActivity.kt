package com.ulisesdiaz.gridview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnGridSimple = findViewById<Button>(R.id.btnGridSimple)
        val btnGridCustom = findViewById<Button>(R.id.btnGridCustom)

        btnGridSimple.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("IDGRID", "grid-simple")
            startActivity(intent)
        }

        btnGridCustom.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("IDGRID", "grid-custom")
            startActivity(intent)
        }
    }
}