package com.example.eslami.ui.moshaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.R

class adapterDetails(val myListDetails:List<String>):RecyclerView.Adapter<adapterDetails.myViewHolder>() {

   inner class myViewHolder ( itemView:View):RecyclerView.ViewHolder(itemView){

      var textView = itemView.findViewById<TextView>(R.id.textMoshaf)
        var counterView = itemView.findViewById<TextView>(R.id.counter)
        fun bind(detail: String,counter:String){
            textView.text = detail
            counterView.text =counter

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.content_detailed_rv,parent,false )
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int =myListDetails.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
          val detail =  myListDetails[position]
       var counter =position+1
        holder.bind(detail, counter.toString())

    }


}