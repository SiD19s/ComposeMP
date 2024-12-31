package com.yoda.cbt.models

// Sealed class to represent result states (loading, success, failure)
sealed class FeedbackResult<out T> {

    // Represents a loading state
    object Loading : FeedbackResult<Nothing>()

    // Represents a successful result with a value
    data class Success<out T>(val data: T) : FeedbackResult<T>()

    // Represents a failure result with an exception
    data class Failure(val exception: Throwable) : FeedbackResult<Nothing>()

    // Extension function to create a Loading result
    companion object {
        fun <T> loading(): FeedbackResult<T> = Loading

        fun <T> success(data: T): FeedbackResult<T> = Success(data)

        fun failure(exception: Throwable): FeedbackResult<Nothing> = Failure(exception)
    }
}
sealed class ReviewState {
    object Idle : ReviewState()
    object Success : ReviewState()
    object Failure : ReviewState()
}