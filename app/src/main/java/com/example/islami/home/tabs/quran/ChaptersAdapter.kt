package com.example.islami.home.tabs.quran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterBinding
import com.example.islami.model.Chapter

class ChaptersAdapter(val chapters: List<Chapter>) :
    RecyclerView.Adapter<ChaptersAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding: ItemChapterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.itemBinding.enTitleTv.text = chapter.titleEn
        holder.itemBinding.arTitleTv.text = chapter.titleAr
        holder.itemBinding.numberVersesTv.text = chapter.versesNumber
        holder.itemBinding.chapterIndexTv.text = "${chapter.index}"

        onItemClick?.let { onClick ->

            holder.itemView.setOnClickListener {
                onClick.onItemClicked(position, chapter)
            }

        }


    }

    var onItemClick: OnItemClick? = null

    fun interface OnItemClick {
        fun onItemClicked(position: Int, chapter: Chapter)
    }


}