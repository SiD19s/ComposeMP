package org.example.composemp.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ModerationResponse(
    val id: String,
    val model: String,
    val results: List<ModerationResult>
)

@Serializable
data class ModerationResult(
    val categories: Map<String, Boolean>,
    @SerialName("category_scores")
    val categoryScores: Map<String, Float>,
    val flagged: Boolean
)
