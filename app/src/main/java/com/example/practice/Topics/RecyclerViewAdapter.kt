package com.example.practice.Topics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R

class RecyclerViewAdapter(private val context:Context,private val arrContact:MutableList<ContactModel>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgContact:ImageView = itemView.findViewById(R.id.imgContact)
        val numberTxt:TextView = itemView.findViewById(R.id.numberTxt)
        val nameTxt:TextView = itemView.findViewById(R.id.nameTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_card_row,parent,false))
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgContact.setImageResource(arrContact[position].img)
        holder.nameTxt.text = arrContact[position].name
        holder.numberTxt.text = arrContact[position].number
    }
}