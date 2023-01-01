package com.ozkanaltunbas.peakyblinders

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.recycler_row.view.*

//bu sınıfta RecyclerView ile MainActicityi bağlıyoruz yani oluşturduğumuz tasarım
//direkt olarak MainActivity de olacak.

class RecyclerAdapter(val List : ArrayList<String> , val Images : ArrayList<Int>, val Desc : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ShelbyVH>() {

    class ShelbyVH(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelbyVH {
        //Olyşturduğumuz recycler_row'u buraya bağladık artık.
        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return ShelbyVH(itemView)
    }

    override fun onBindViewHolder(holder: ShelbyVH, position: Int) {
        //burada  görünümü recyclerView a bağladık ve listeyi al numarasına göre ver dedik.
        holder.itemView.recyclerViewTextView.text = List.get(position)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DesciriptionActivity::class.java)
            intent.putExtra("Names",List.get(position))
            intent.putExtra("Desc",Desc.get(position))
            intent.putExtra("Images",Images.get(position))
            holder.itemView.context.startActivity(intent)
        }


    }
     //Burada item sayısını verdik onu da MainActivity de RecyclerAdapter'ı init edip içine ArrayList verdik bu arrayListi List diye atadık.
    override fun getItemCount(): Int {
            return List.size
    }


}