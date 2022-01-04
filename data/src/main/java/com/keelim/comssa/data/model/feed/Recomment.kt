package com.keelim.comssa.data.model.feed

data class Recomment(
    val id : Int,
    val name : String,
    val imageUrl : Int,
    val comment : String,
    val isOwner : Boolean,
    val date : String,
    val time : String,
    val isHeartClick : Boolean,
    val heartCount : Int,
)
