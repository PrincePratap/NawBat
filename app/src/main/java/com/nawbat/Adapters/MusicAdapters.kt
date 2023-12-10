package com.nawbat.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nawbat.MVVM.APIs.Event.DataEvent
import com.nawbat.MVVM.APIs.Music.DataMusic
import com.nawbat.databinding.FragmentLibraryBinding
import com.nawbat.databinding.LayoutMusicBinding

class MusicAdapters( val list: List<DataMusic>) : RecyclerView.Adapter<MusicAdapters.MyViewHolder>() {
    class MyViewHolder (val binding: LayoutMusicBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: DataMusic){
//            Glide.with(binding.root.context).load(item.eventImageDetails[0].image).into(binding.i)

            Glide.with(binding.root.context).load(item.image).centerCrop().into(binding.ivMusicLyrics)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return  MyViewHolder(LayoutMusicBinding.inflate(LayoutInflater.from(parent.context,),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

}
