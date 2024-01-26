package com.example.hw_1_7.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_1_7.databinding.ItemDoorsBinding

class DoorsAdapter : Adapter<DoorsAdapter.DoorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        return DoorsViewHolder(
            ItemDoorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 50
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.toBind()
    }

    inner class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
        fun toBind() {
            itemView.setOnClickListener {
                if (binding.imgDoor.visibility == View.GONE) {
                    binding.imgDoor.visibility =
                        View.VISIBLE; binding.btnPlay.visibility = View.VISIBLE
                } else {
                    binding.imgDoor.visibility = View.GONE
                    binding.btnPlay.visibility = View.GONE
                }
            }
        }
    }
}