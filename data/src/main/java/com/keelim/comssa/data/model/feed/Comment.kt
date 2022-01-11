package com.keelim.comssa.data.model.feed

import androidx.annotation.DrawableRes

data class Comment(
    val id: Int,
    val name: String,
    @DrawableRes val imageUrl: Int,
    val comment: String,
    val isOwner: Boolean,
    val date: String,
    val time: String,
    val isHeartClick: Boolean,
    val heartCount: Int,
    val recommentCount: Int,
    val recommentList: List<Recomment>,
)

val comments = listOf(
    Comment(
        0,
        "슈카",
        0,
        "하락장입니다 여러분 !",
        true,
        "2020,05,17",
        "12:12",
        false,
        0,
        0,
        listOf()
    ),
    Comment(
        0,
        "슈카",
        0,
        "하락장입니다 여러분 !",
        true,
        "2020,05,17",
        "12:12",
        true,
        3,
        0,
        listOf()
    ),
    Comment(
        0,
        "슈카",
        0,
        "하락장입니다 여러분 !",
        true,
        "2020,05,17",
        "12:12",
        true,
        4,
        1,
        listOf(
            Recomment(
                0,
                "gogo",
                0,
                "gazuaaa",
                false,
                "2020,05,17",
                "12:20",
                false,
                0,
            )
        )
    )
)


