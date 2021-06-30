package com.keelim.comssa.data.repository

import com.keelim.comssa.data.model.Review

interface ReviewRepository {
    suspend fun getLatestReview(dataId:String): Review?

    suspend fun getAllReviews(dataId: String): List<Review>

    suspend fun getAllUserReviews(userId: String): List<Review>

    suspend fun addReview(review:Review): Review

    suspend fun removeReview(review:Review)
}