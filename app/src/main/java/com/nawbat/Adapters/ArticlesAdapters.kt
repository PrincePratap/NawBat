package com.nawbat.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nawbat.MVVM.APIs.Articles.DataArticles
import com.nawbat.databinding.LayoutArticlesBinding

class ArticlesAdapters(private val list: List<DataArticles>) : RecyclerView.Adapter<ArticlesAdapters.MyViewHolder>() {
    class MyViewHolder (val binding: LayoutArticlesBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(item: DataArticles) {
            binding.textArticleLayout.text = item.title
            Glide.with(binding.root.context).load(item.articleImageDetails[0].image).into(binding.ImageArticleLayout)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list[position]
        holder.bind(item)
    }


}
