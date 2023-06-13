package com.astra.astramotormangement.ui.dealer.berau

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.model.Dealer

class BerauAdapter(
    private val listData: List<Dealer>,
    private val itemAdapterCallback: ItemAdapterCallback
) : RecyclerView.Adapter<BerauAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_dealer, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Dealer, itemAdapterCallback: ItemAdapterCallback) {
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_nama_dealer)

            itemView.apply {
                tvTitle.text = data.title

                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: Dealer)
    }
}