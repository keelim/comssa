package com.keelim.feed.ui.recommend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keelim.comssa.data.model.feed.Recomment
import com.keelim.feed.databinding.ItemRecommentBinding

class RecommendAdapter() : RecyclerView.Adapter<RecommendAdapter.RecommentViewHolder>() {
    val recomment_userList = mutableListOf<Recomment>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommentViewHolder {
        return RecommentViewHolder(
            ItemRecommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecommentViewHolder, position: Int) {
        holder.onBind(recomment_userList[position])
    }

    override fun getItemCount(): Int {
        return recomment_userList.size
    }


    inner class RecommentViewHolder(private val binding: ItemRecommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Recomment) = with(binding){
            Glide.with(imageViewIcTagColor)
                .load(data.imageUrl)
                .override(40, 40)
                .into(imageViewIcTagColor)

            textViewHeartCount.text = data.heartCount.toString()// 좋아요 개수
            imageButtonReHeart.isSelected = data.isHeartClick //좋아요 버튼
            textViewReDateTime.text = "${data.date}  ${data.time}" // 날짜
            textViewReComment.text = data.comment // 댓글 내용
            textViewReName.text = data.name

            when (data.isOwner) {
                true -> imageViewIsOwner.visibility = View.VISIBLE
                false -> imageViewIsOwner.visibility = View.GONE
            }

            imageButtonReHeart.setOnClickListener {
                var heartCount = Integer.parseInt(textViewHeartCount.text as String)
                with(it) {
                    isSelected = !isSelected

                    if (isSelected) {
                        heartCount += 1
                    } else {
                        heartCount -= 1
                    }
                }
                textViewHeartCount.text = heartCount.toString()
            }
        }
    }
}

