package com.example.eslami.ui.ahadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.R

class adapterAhadeth(val myList: MutableList<ahadethModel>) :
    RecyclerView.Adapter<adapterAhadeth.myviewholder>() {
    class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textrv)

        fun bind(title: String) {
            textView.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.content_ahadeth, parent, false)
        return myviewholder(inflate)
    }

    override fun getItemCount(): Int = myList.size
    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        val hadeth = myList[position]

        hadeth.title.let { holder.bind(it) }
        click?.let {click->
            holder.itemView.setOnClickListener {
              click.onClick(position, hadeth = hadeth)
            }
        }

    }

    fun interface onRecClick {
        fun onClick(position: Int, hadeth: ahadethModel)
    }

    var click: onRecClick? = null
}