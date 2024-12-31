package org.example.composemp.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TurboRole {
    @SerialName("system")
    system,
    @SerialName("assistant")
    assistant,
    @SerialName("user")
    user
}