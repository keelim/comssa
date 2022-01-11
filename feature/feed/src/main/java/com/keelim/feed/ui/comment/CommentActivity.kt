package com.keelim.feed.ui.comment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.keelim.comssa.data.model.feed.comments
import com.keelim.feed.databinding.ActivityCommentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCommentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        imageViewGoUp.setOnClickListener {
            nestedScrollView.scrollTo(0, 0)
        }
        imageViewGoBack.setOnClickListener {
            super.onBackPressed()
        }

        editTextWriteComment.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { checkHandling() }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { checkHandling() }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { checkHandling() }
        })


        recyclerViewComment.adapter = CommentAdapter().apply {
            submitList(comments)
        }
    }
    private fun checkHandling() = with(binding){
        if(editTextWriteComment.text.isNotBlank()){
            buttonCommentRegister.isEnabled = true
            buttonCommentRegister.isClickable = true
        } else{
            buttonCommentRegister.isEnabled = false
            buttonCommentRegister.isClickable = false
        }
    }
}