package org.example.composemp.models

import kotlinx.serialization.Serializable

@Serializable
data class ModerationRequest(
    val input: String
)

