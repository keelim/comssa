package com.keelim.feed.ui.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keelim.common.toGone
import com.keelim.common.toVisible
import com.keelim.comssa.data.model.feed.Comment
import com.keelim.feed.databinding.ItemCommentBinding
import com.keelim.feed.ui.recommend.RecommendAdapter

class CommentAdapter : ListAdapter<Comment, CommentAdapter.CommentViewHolder>(diffUtil) {
    inner class CommentViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Comment)  = with(binding) {
            Glide.with(imageViewIcColorTag.context)
                .load(data.imageUrl)
                .override(40, 40)
                .into(imageViewIcColorTag)

            textViewName.text = data.name
            textViewComment.text = data.comment
            imageButtonHeart.isSelected = data.isHeartClick
            textViewDateTime.text = "${data.date} ${data.time} "
            textViewHeartCounter.text = data.heartCount.toString()
            textViewFoldUnfoldRecomment.text = "답글 ${data.recommentCount}개 보기 "

            recyclerView.apply{
                adapter = RecommendAdapter().apply{
                    recomment_userList.addAll(data.recommentList)
                }
            }

            when (data.isOwner) {
                true -> imageViewIsOwner.toVisible()
                false -> imageViewIsOwner.toGone()
            }

            imageButtonHeart.setOnClickListener {
                var heartCount = Integer.parseInt(binding.textViewHeartCounter.text as String)
                with(imageButtonHeart) {
                    isSelected = !isSelected

                    if (isSelected) {
                        heartCount += 1
                    } else {
                        heartCount -= 1
                    }
                }
                textViewHeartCounter.text = heartCount.toString()
            }

            textViewFoldUnfoldRecomment.setOnClickListener {
                if (recyclerView.visibility == View.GONE) {
                    textViewFoldUnfoldRecomment.text = "답글 숨기기"
                    recyclerView.toVisible()
                } else if (recyclerView.visibility == View.VISIBLE) {
                    textViewFoldUnfoldRecomment.text = "답글 ${data.recommentCount}개 보기"
                    recyclerView.toGone()
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            ItemCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
                return oldItem == newItem
            }
        }
    }
}

