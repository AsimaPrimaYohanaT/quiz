package com.example.quizstechoqapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quizstechoqapp.databinding.ItemPhotoBinding
import com.example.quizstechoqapp.response.ResponseItem

class Task3Adapter(private val data: List<ResponseItem>) :
    RecyclerView.Adapter<Task3Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = data[position]
        if (data != null) {
            holder.bind(data)
        }
    }

    class MyViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResponseItem) {
            Glide.with(itemView)
                .load(data.thumbnailUrl)
                .into(binding.ivPhotoprofile)
            binding.Name.text = data.title
            binding.url.text = data.url
        }
    }

}