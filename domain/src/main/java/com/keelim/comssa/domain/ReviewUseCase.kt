package com.keelim.comssa.domain

import com.keelim.comssa.data.model.Data
import com.keelim.comssa.data.model.DataReviews
import com.keelim.comssa.data.model.Review
import com.keelim.comssa.data.model.ReviewedData
import com.keelim.comssa.data.model.User
import com.keelim.comssa.data.repository.DataRepository
import com.keelim.comssa.data.repository.ReviewRepository
import com.keelim.comssa.data.repository.UserRepository
import javax.inject.Inject

class ReviewUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository,
    private val dataRepository: DataRepository,
) {
    suspend fun submitReview(
        data: Data,
        content: String,
        score: Float
    ): Review {
        var user = userRepository.getUser()

        user ?: run {
            userRepository.saveUser(User())
            user = userRepository.getUser()
        }

        return reviewRepository.addReview(
            Review(
                userId = user!!.id,
                dataId = data.id,
                content = content,
                score = score
            )
        )
    }

    suspend fun getUserReviewedData(): List<ReviewedData> {
        val user = userRepository.getUser()
        user ?: kotlin.run {
            userRepository.saveUser(User())
            return emptyList()
        }
        val reviews = reviewRepository.getAllReviews(user.id!!)
            .filter { it.dataId.isNullOrBlank().not() }

        if (reviews.isEmpty()) {
            return emptyList()
        }

        return dataRepository
            .getData(reviews.map { it.dataId!! })
            .mapNotNull { data ->
                val relatedReview = reviews.find { it.dataId == data.id }
                relatedReview?.let { ReviewedData(data, it) }
            }
    }

    suspend fun getAllDataReview(dataId: String): List<Review> {
        return reviewRepository.getAllReviews(dataId)
    }

    suspend fun saveDataReview(dataId: String): DataReviews {
        val reviews = reviewRepository.getAllReviews(dataId)
        val user = userRepository.getUser()

        user ?: run {
            userRepository.saveUser(User())
            return DataReviews(null, reviews)
        }

        return DataReviews(
            reviews.find { it.userId == user.id },
            reviews.filter { it.userId != user.id }
        )
    }

    suspend fun deleteReview(review: Review) =
        reviewRepository.removeReview(review)
}