package com.example.trellofake.model

import java.util.UUID

data class Board(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val tasklists: MutableList<TaskList> = mutableListOf()
)
