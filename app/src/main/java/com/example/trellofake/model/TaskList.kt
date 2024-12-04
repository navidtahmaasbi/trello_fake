package com.example.trellofake.model

import java.util.UUID

data class TaskList(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val cards: MutableList<Card> = mutableListOf()
)
