package com.keelim.feed.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keelim.feed.R
import com.keelim.comssa.data.model.feed.Feed
import com.keelim.feed.databinding.ItemFeedListBinding

class FeedAdapter(val itemClick: (Feed) -> Unit) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>(){
    val feedList = mutableListOf<Feed>()

    class FeedViewHolder(private val binding: ItemFeedListBinding, val itemClick: (Feed) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Feed) {

            Glide.with(binding.imageviewFeedListMainImage.context)
                .load(R.drawable.img_post)
                .into(binding.imageviewFeedListMainImage)

            binding.apply {
                textviewFeedListTitle.text = data.title
                textviewFeedListContent.text = data.content
                textviewFeedListDate.text = data.date
                imageviewFeedListHeart.isSelected = data.isHeartPressed
                textviewFeedListHeartNum.text = data.heartNum.toString()
                textviewFeedListCommentNum.text = data.commentNum.toString()

                constraintlayoutFeedHeart.setOnClickListener {
                    val parseInt = data.heartNum
                    if(!imageviewFeedListHeart.isSelected) {
                        imageviewFeedListHeart.isSelected = true
                        textviewFeedListHeartNum.text = (parseInt+1).toString()
                    }
                    else {
                        imageviewFeedListHeart.isSelected = false
                        textviewFeedListHeartNum.text = parseInt.toString()
                    }
                }

                binding.root.setOnClickListener{
                    itemClick(data)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = ItemFeedListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.onBind(feedList[position])
    }

    override fun getItemCount(): Int = feedList.size
}