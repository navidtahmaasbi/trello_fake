package com.example.trellofake.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.trellofake.model.Board
import com.example.trellofake.viewmodel.BoardViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardScreen{
    @Composable
    fun DashboardScreen(viewModel: BoardViewModel = viewModel(), onBoardSelected: (Board) -> Unit) {
        val boards by viewModel.boards.observeAsState(emptyList())

        Column {
            LazyColumn {
                items(boards) { board ->
                    Text(
                        text = board.name,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { onBoardSelected(board) }
                    )
                }
            }

            FloatingActionButton(onClick = { viewModel.addBoard("New Board") }) {
                Icon(Icons.Default.Add, contentDescription = "Add Board")
            }
        }
    }

}