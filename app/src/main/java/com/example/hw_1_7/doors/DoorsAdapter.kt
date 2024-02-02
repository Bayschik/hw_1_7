package com.example.hw_1_7.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw_1_7.databinding.ItemDoorsBinding
import com.example.hw_1_7.response.door.DoorModel

class DoorsAdapter: ListAdapter<DoorModel.Data, DoorsViewHolder>(
    DoorDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoorsViewHolder {
        return DoorsViewHolder(
            ItemDoorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DoorsViewHolder(private val binding: ItemDoorsBinding) : ViewHolder(binding.root) {
    fun bind(position: DoorModel.Data) {
        itemView.setOnClickListener {
            if (binding.imgDoor.visibility == View.GONE) {
                binding.imgDoor.visibility =
                    View.VISIBLE; binding.btnPlay.visibility = View.VISIBLE
            } else {
                binding.imgDoor.visibility = View.GONE
                binding.btnPlay.visibility = View.GONE
            }
        }
        binding.tvNameDoor.text = position.name
        Glide.with(binding.imgDoor).load(position.snapshot).into(binding.imgDoor)
    }
    /*
    itemView.setOnClickListener {
                if (binding.imgDoor.visibility == View.GONE) {
                    binding.imgDoor.visibility =
                        View.VISIBLE; binding.btnPlay.visibility = View.VISIBLE
                } else {
                    binding.imgDoor.visibility = View.GONE
                    binding.btnPlay.visibility = View.GONE
                }
            }
     */
}

class DoorDiffCallback : DiffUtil.ItemCallback<DoorModel.Data>() {
    override fun areContentsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) = oldItem.id == newItem.id
    override fun areItemsTheSame(oldItem: DoorModel.Data, newItem: DoorModel.Data) = oldItem == newItem
}