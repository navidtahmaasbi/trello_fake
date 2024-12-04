package com.example.trellofake.model

import java.util.UUID

data class Card(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String? = null,
    val dueDate: String? = null
)
