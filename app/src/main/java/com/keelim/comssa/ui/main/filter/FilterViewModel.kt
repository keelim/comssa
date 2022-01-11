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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.comssa.data.db.entity.Search
import com.keelim.comssa.domain.FavoriteUseCase
import com.keelim.comssa.domain.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val favoriteUseCase: FavoriteUseCase,
) : ViewModel() {
    private var _state: MutableStateFlow<FilterState> = MutableStateFlow(FilterState.UnInitialized)
    val state: StateFlow<FilterState>
        get() = _state

    private val data: MutableStateFlow<List<Search>> = MutableStateFlow(emptyList())
    private val filter: MutableStateFlow<List<Search>> = MutableStateFlow(emptyList())

    init {
        getInitData()
    }

    fun favorite(favorite: Int, id: Int) = viewModelScope.launch {
        when (favorite) {
            0 -> favoriteUseCase.update(1, id)
            1 -> favoriteUseCase.update(0, id)
        }
    }

    private fun getInitData() = viewModelScope.launch {
        _state.emit(
            FilterState.Loading
        )
        runCatching {
            searchUseCase.getSearchData()
        }.onSuccess {
            _state.emit(
                FilterState.Success(
                    it
                )
            )
            data.emit(it)
        }.onFailure {
            FilterState.Error(
                it.message!!
            )
        }
    }

    fun filter(query: String) {
        data
            .onStart {
                _state.emit(
                    FilterState.UnInitialized
                )
            }
            .onEach { searches ->
                _state.emit(
                    FilterState.Loading
                )
                val temp = searches.filter { it.category!!.contains(query) }
                _state.emit(
                    FilterState.Success(
                        temp
                    )
                )
            }
            .catch {
                it.printStackTrace()
                _state.emit(FilterState.Error("에러가 발생하였습니다."))
            }
            .launchIn(viewModelScope)
    }
}
