package com.yoda.cbt.models

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant


//data class ConversationModel(
//    var id: String = Date().time.toString(),
//    var title: String = "",
//    var createdAt: Date = Date(),
//)

data class ConversationModel(
    var id: String = Clock.System.now().toEpochMilliseconds().toString(),
    var title: String = "",
    var createdAt: Instant = Clock.System.now()
)