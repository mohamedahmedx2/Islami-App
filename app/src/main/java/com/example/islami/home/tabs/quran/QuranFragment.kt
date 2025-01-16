package com.example.islami.home.tabs.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.home.AppConstants
import com.example.islami.home.tabs.chapterDetails.ChapterDetailsActivity

class QuranFragment : Fragment() {
    lateinit var viewBinding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentQuranBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    lateinit var adapter: ChaptersAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChaptersAdapter(chapters)
        adapter.onItemClick = ChaptersAdapter.OnItemClick { position, chapter ->
            val intent = Intent(activity, ChapterDetailsActivity::class.java)
            intent.putExtra(AppConstants.EXTRA.EXTRA_CHAPTER, chapter)
            startActivity(intent)
        }
        viewBinding.chapterRecycler.adapter = adapter
    }


    val chapters = AppConstants.getChapters()


}