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
package com.keelim.comssa.domain

import androidx.paging.PagingData
import com.keelim.comssa.data.db.entity.Search
import com.keelim.comssa.data.model.PasswordResult
import com.keelim.comssa.data.repository.IoRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchUseCase @Inject constructor(
    private val ioRepository: IoRepository,
) {

    suspend operator fun invoke(keyword: String?): List<Search> {
        return ioRepository.getSearch(keyword.orEmpty())
    }

    fun getContent(query:String = ""): Flow<PagingData<Search>> {
        return ioRepository.getContentItemsByPaging(query)
    }

    fun getFavorite(): Flow<PagingData<Search>>{
        return ioRepository.getFavoriteItemsByPaging()
    }
    
    suspend fun getDownloadLink(password:String): PasswordResult{
        return ioRepository.getDownloadLink(password)
    }
}
