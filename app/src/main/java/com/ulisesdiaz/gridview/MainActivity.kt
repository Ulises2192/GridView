package com.ulisesdiaz.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import com.ulisesdiaz.gridview.adapters.AdaptadorCustom
import com.ulisesdiaz.gridview.model.Fruta

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grid:GridView = findViewById(R.id.grid)

        val valor = intent.getStringExtra("IDGRID")

        if (valor == "grid-simple"){
            // Grid Simple
            val frutas = ArrayList<String>()
            frutas.add("Manzana")
            frutas.add("Platano")
            frutas.add("Sandia")
            frutas.add("Durazno")

            val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
            grid.adapter = adaptador

            grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, frutas.get(position), Toast.LENGTH_SHORT).show()
            }
        }else if (valor == "grid-custom"){
            // Grid personalizado
            val frutas = ArrayList<Fruta>()
            frutas.add(Fruta("Manzana", R.drawable.manzana))
            frutas.add(Fruta("Platano", R.drawable.platano))
            frutas.add(Fruta("Sandia", R.drawable.sandia))
            frutas.add(Fruta("Durazno", R.drawable.durazno))

            frutas.add(Fruta("Manzana", R.drawable.manzana))
            frutas.add(Fruta("Platano", R.drawable.platano))
            frutas.add(Fruta("Sandia", R.drawable.sandia))
            frutas.add(Fruta("Durazno", R.drawable.durazno))

            frutas.add(Fruta("Manzana", R.drawable.manzana))
            frutas.add(Fruta("Platano", R.drawable.platano))
            frutas.add(Fruta("Sandia", R.drawable.sandia))
            frutas.add(Fruta("Durazno", R.drawable.durazno))

            val adaptador = AdaptadorCustom(this, frutas)
            grid.adapter = adaptador

            grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_LONG).show()
            }
        }
    }
}