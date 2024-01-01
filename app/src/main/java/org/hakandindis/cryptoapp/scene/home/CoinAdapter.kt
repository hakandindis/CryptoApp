package org.hakandindis.cryptoapp.scene.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.hakandindis.cryptoapp.databinding.RowCoinRecyclerItemBinding

class CoinAdapter(private val listener: (item: CoinItem) -> Unit) : ListAdapter<CoinItem, CoinAdapter.CoinViewHolder>(DIFF_UTIL) {

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<CoinItem>() {
            override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem) = (oldItem.id == newItem.id)
            override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem) = (oldItem == newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowCoinRecyclerItemBinding.inflate(inflater, parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CoinViewHolder(private val binding: RowCoinRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CoinItem) {
            binding.coin = item
            binding.root.setOnClickListener { listener.invoke(item) }
        }
    }
}