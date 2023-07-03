package com.astra.astramotormangement.ui.dealer.balikpapan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.data.response.dealer.DealerItem
import com.astra.astramotormangement.model.Dealer

class BalikpapanAdapter(
    private val itemAdapterCallback: ItemAdapterCallback
) : ListAdapter<DealerItem, BalikpapanAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_dealer, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dealer = getItem(position)
        holder.bind(dealer, itemAdapterCallback)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DealerItem, itemAdapterCallback: ItemAdapterCallback) {
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_nama_dealer)

            itemView.apply {
                tvTitle.text = data.name

                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: DealerItem)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DealerItem>() {
            override fun areItemsTheSame(oldItem: DealerItem, newItem: DealerItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DealerItem, newItem: DealerItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}