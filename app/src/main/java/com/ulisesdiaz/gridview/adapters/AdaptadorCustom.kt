package com.ulisesdiaz.gridview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ulisesdiaz.gridview.R
import com.ulisesdiaz.gridview.model.Fruta

class AdaptadorCustom(var context:Context, items:ArrayList<Fruta>): BaseAdapter() {

    var items:ArrayList<Fruta>? = null

    init {
        this.items = items
    }
    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var holder:ViewHolder? = null

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(view)
            view.tag = holder
        }else{
            holder = view.tag as? ViewHolder
        }

        val item = items?.get(position) as? Fruta
        holder?.nombre?.text = item?.nombre
        holder?.imagen?.setImageResource(item?.imagen!!)

        return view!!
    }

    private class ViewHolder(view:View){
        var nombre:TextView?
        var imagen:ImageView?

        init {
            nombre = view.findViewById(R.id.txtNombre)
            imagen = view.findViewById(R.id.imgFruta)
        }
    }
}