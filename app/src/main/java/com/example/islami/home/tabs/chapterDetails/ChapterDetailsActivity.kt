package com.example.islami.home.tabs.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityChapterDetailsBinding
import com.example.islami.home.AppConstants
import com.example.islami.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityChapterDetailsBinding
    var chapter: Chapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        init()
        initRecycleView()
    }

    lateinit var adapter: VersesAdapter
    private fun initRecycleView() {
        adapter = VersesAdapter(verseList)
        viewBinding.content.versesRecycler.adapter = adapter
    }

    // lateinit var toolbar: Toolbar
    fun init() {
//         toolbar =  findViewById(R.id.toolBar);
        setSupportActionBar(viewBinding.toolBar.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            chapter = intent.getParcelableExtra(
                AppConstants.EXTRA.EXTRA_CHAPTER,
                Chapter::class.java
            )
        } else {
            chapter = intent.getParcelableExtra(
                AppConstants.EXTRA.EXTRA_CHAPTER

            )
        }
        viewBinding.toolBar.toolbarTitle.text = chapter?.titleEn
        viewBinding.content.chapterTitleAr.text = chapter?.titleAr
        readChapterDetails(chapter!!.index)

    }

    lateinit var verseList: List<String>
    fun readChapterDetails(chapterIndex: Int) {
        val content =
            assets?.open("quran/${chapterIndex}.txt")?.bufferedReader().use { it?.readText() }
        verseList = content?.split("\n")!!


    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}