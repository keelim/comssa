package com.keelim.comssa.data.db.entity.mapper

import com.keelim.comssa.data.api.response.ResponseSheet
import com.keelim.comssa.data.db.entity.Search

fun ResponseSheet.toSearch(): List<Search> {
    return this.values.map {
        Search(
            id = it[0].toInt(),
            category = it[1],
            title = it[2],
            description = it[3],
            favorite = 0,
            relation = it[4],
        )
    }
}