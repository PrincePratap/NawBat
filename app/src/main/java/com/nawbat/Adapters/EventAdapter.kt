package com.nawbat.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nawbat.MVVM.APIs.Articles.DataArticles
import com.nawbat.MVVM.APIs.Event.DataEvent

import com.nawbat.databinding.LayoutEventsBinding

class EventAdapter(val list: List<DataEvent>) : RecyclerView.Adapter<EventAdapter.MyViewHolder>() {
    class MyViewHolder (val binding: LayoutEventsBinding) : RecyclerView.ViewHolder(binding.root) {



        fun bind(item: DataEvent){
            Glide.with(binding.root.context).load(item.eventImageDetails[0].image).into(binding.ivEventLayout)
            binding.textDateEventLayout.text = item.date
            binding.textEventNameEventLayout.text  = item.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list[position]
        holder.bind(item)
    }


}
