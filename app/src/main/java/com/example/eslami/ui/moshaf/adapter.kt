import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.R

class QuranAdapter(private val listQuran:List<String>):RecyclerView.Adapter<QuranAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
         var textview1: TextView? = itemView.findViewById(R.id.text1)
        fun bind(item:String){
            textview1?.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.content_quran,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return listQuran.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     val  item = listQuran[position]
        holder.bind(item)
        holder.itemView.setOnClickListener(View.OnClickListener {
         v: View? ->
            click?.onClick(position,item)
        })

    }
  fun  interface clickRv{
        fun onClick(position:Int,item: String)
    }
    var click: clickRv? = null
}