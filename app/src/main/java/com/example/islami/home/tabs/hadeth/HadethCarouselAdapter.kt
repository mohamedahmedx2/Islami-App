package com.example.islami.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.model.Hadeth

class HadethCarouselAdapter(val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethCarouselAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        )

        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.viewBinding.titleHadeth.text = hadeth.title
        holder.viewBinding.contentHadethTv.text = hadeth.content
    }


    class ViewHolder(val viewBinding: ItemHadethBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {}

}