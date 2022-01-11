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
package com.keelim.comssa.ui.main.center

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.keelim.comssa.data.model.main.center.Center
import com.keelim.comssa.databinding.ItemCenterBinding

class CenterAdapter : ListAdapter<Center, CenterAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemCenterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Center) = with(binding) {
            icon.load(item.url){
                crossfade(true)
            }
            title.text = item.title
            desc.text = item.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCenterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Center>() {
            override fun areItemsTheSame(oldItem: Center, newItem: Center): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(oldItem: Center, newItem: Center): Boolean {
                return newItem == oldItem
            }
        }
    }
}
