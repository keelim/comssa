package com.keelim.comssa.ui.main.search

import com.keelim.comssa.data.db.entity.Search

sealed class SearchState{
    object UnInitialized : SearchState()
    object Loading : SearchState()
    data class Success(
        val data: List<Search>
    ) : SearchState()

    data class Error(
        val message: String
    ) : SearchState()
}
