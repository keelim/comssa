package com.keelim.comssa.data.model.feed

data class Feed(
    val postId : Int,
    val img : Int,
    val title : String,
    val content : String,
    val date : String,
    val isOwner : Boolean,
    val isHeartPressed : Boolean,
    val heartNum : Int,
    val commentNum : Int
)
