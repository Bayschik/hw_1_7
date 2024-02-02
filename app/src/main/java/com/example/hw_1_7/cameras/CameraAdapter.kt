package com.example.hw_1_7.cameras

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw_1_7.databinding.ItemCameraBinding
import com.example.hw_1_7.response.camera.CameraSecond

class CameraAdapter: ListAdapter<CameraSecond.Data.Camera, CameraViewHolder>(
    CameraDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CameraViewHolder {
        return CameraViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CameraViewHolder(private val binding: ItemCameraBinding) : ViewHolder(binding.root) {
    fun bind(position: CameraSecond.Data.Camera) {
        binding.tvCamera.text = position.name
        binding.tvRoomName.text = position.room
        Glide.with(binding.imgRoom).load(position.snapshot).into(binding.imgRoom)
    }
}

class CameraDiffCallback : DiffUtil.ItemCallback<CameraSecond.Data.Camera>() {
    override fun areContentsTheSame(oldItem: CameraSecond.Data.Camera, newItem: CameraSecond.Data.Camera) = oldItem.id == newItem.id
    override fun areItemsTheSame(oldItem: CameraSecond.Data.Camera, newItem: CameraSecond.Data.Camera) = oldItem == newItem
}