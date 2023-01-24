package com.ozkanaltunbas.kriptouygulamas.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozkanaltunbas.kriptouygulamas.R
import com.ozkanaltunbas.kriptouygulamas.databinding.RowLayoutBinding
import com.ozkanaltunbas.kriptouygulamas.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>,private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private val colors : Array<String> = arrayOf("#F44336", "#9C27B0", "#3F51B5", "#2196F3", "#009688", "#4CAF50", "#8BC34A", "#CDDC39")
    class RowHolder(private val binding : RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind (cryptoModel : CryptoModel, colors : Array<String>, position: Int, listener :Listener){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            binding.CryptoModel = cryptoModel
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8 ]))


        }

    }
    //row_layout u birbirine bağlıyoruz RowHolder döndürürüz.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {

    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
    return RowHolder(view)

    }
    //crpytomodelsdan al
    override fun getItemCount(): Int {
        return cryptoList.size

    }
    //hangi item hangi veriyi gösterecek.
    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }
}