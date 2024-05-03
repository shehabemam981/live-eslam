package com.example.eslami.ui.radio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.R
import com.example.eslami.ui.radio.model.Radio

class adapterRadio(val radioList: List<Radio?>?):RecyclerView.Adapter<adapterRadio.myViewHolder>() {
    class myViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
     val textRadio = itemView.findViewById<TextView>(R.id.textRadio)
     val imageRadio = itemView.findViewById<ImageView>(R.id.imageRadio)
     val toggleButton = itemView.findViewById<ImageView>(R.id.togglebutton)
        fun bind(text:String){
            textRadio.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.radio_content_rv,parent,false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int = radioList!!.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = radioList!!.get(position)
        item!!.name?.let { holder.bind(it) }
        holder.toggleButton.setOnClickListener{

            clickOfMusic!!.onClick(position,item,holder.toggleButton)

        }

    }
   fun  interface clickMusic{
     fun  onClick(position: Int, item: Radio,imageView: ImageView)
   }
 var clickOfMusic : clickMusic? = null

}