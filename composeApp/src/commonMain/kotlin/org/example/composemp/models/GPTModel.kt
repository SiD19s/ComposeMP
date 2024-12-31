package com.yoda.cbt.models

enum class GPTModel(val model: String, val maxTokens: Int, val isChatCompletion: Boolean = true) {
    gpt4oMini("gpt-4o-mini", 4096),
    gpt35Turbo("gpt-3.5-turbo", 4096),
}