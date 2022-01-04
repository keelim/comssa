/*
 * Designed and developed by 2021 keelim (Jaehyun Kim)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.keelim.comssa.ui.main.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.keelim.comssa.data.db.entity.Search
import com.keelim.comssa.databinding.ItemSearchBinding
import com.keelim.comssa.utils.toGone
import com.keelim.comssa.utils.toVisible

class FilterAdapter(
    private val favoriteListener: (Int, Int) -> Unit
) : ListAdapter<Search, FilterAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) = with(binding) {
            title.text = item.title
            description.text = if (item.description.isNullOrEmpty()) {
                "아직 설명 자료가 없네요."
            } else {
                item.description
            }
            favoriteSwitch.isChecked = item.favorite == 1
            favoriteSwitch.setOnClickListener {
                favoriteListener.invoke(item.favorite, item.id)
            }
            root.setOnClickListener {
                if(description.visibility == View.VISIBLE){
                    description.toGone()
                } else{
                    description.toVisible()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
                return newItem == oldItem
            }
        }
    }
}
