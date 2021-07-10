package com.example.mvvm_retrofit.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_retrofit.databinding.PostItemBinding
import com.example.mvvm_retrofit.network.response.User

class PostAdapter(private var list: List<User>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(u : User) {
            binding.tvDescription.text = u.body
            binding.tvTitle.text = u.title
            binding.tvUsername.text = u.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(it: List<User>?) {
        list = it!!
        notifyDataSetChanged()
    }
}