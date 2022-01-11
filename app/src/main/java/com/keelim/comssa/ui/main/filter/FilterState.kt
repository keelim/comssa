package com.keelim.comssa.ui.main.filter

import com.keelim.comssa.data.db.entity.Search

sealed class FilterState{
    object UnInitialized : FilterState()
    object Loading : FilterState()
    data class Success(
        val data: List<Search>
    ) : FilterState()
    data class Filtered(
        val data: List<Search>
    ) : FilterState()
    data class Error(
        val message: String
    ) : FilterState()
}
