package com.yoda.cbt.models


data class Feedback(
    val message: String,      // Feedback message or comment
    val rating: Float,          // Rating (e.g., 1-5 stars)
    val timestamp: String,      // Timestamp of feedback submission
    val userId: String ,// Optional user ID for tracking (if applicable)
    val type: String // Optional user ID for tracking (if applicable)
)

