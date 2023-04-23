package org.hakandindis.cryptoapp.scene.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.databinding.RowCoinRecyclerItemBinding

class CoinAdapter(private val listener: ItemClickListener) :
    ListAdapter<Coin, CoinAdapter.CoinViewHolder>(CoinDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowCoinRecyclerItemBinding.inflate(inflater, parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(listener, currentList[position])
    }

    inner class CoinViewHolder(binding: RowCoinRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: ItemClickListener, coin: Coin) {

        }
    }
}

object CoinDiffUtil : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin) = (oldItem.id == newItem.id)
    override fun areContentsTheSame(oldItem: Coin, newItem: Coin) = (oldItem == newItem)
}