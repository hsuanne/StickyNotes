package com.example.stickynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stickynotes.ui.theme.StickyNotesTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StickyNotesTheme {
                val viewModel by viewModel<BoardViewModel>()
                BoardView(boardViewModel = viewModel)

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val note = Note(
                        "A",
                        "Hello World",
                        Position(50f,50f),
                        MyColor.HotPink
                    )
                    StickyNote(note)
                }
            }
        }
    }
}

@Composable
fun StickyNote(note: Note) {
    Surface(
        Modifier
            .offset(
                x = note.position.x.dp,
                y = note.position.y.dp
            )
            .size(108.dp, 108.dp),
        color = Color(note.color.color),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = note.text,
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun BoardView(boardViewModel: BoardViewModel) {
    val notes by boardViewModel.allNotes.subscribeAsState(initial = emptyList())

    Box(Modifier.fillMaxSize()) {
        notes.forEach { note ->
            StickyNote(note = note)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StickyNotesTheme {
        StickyNote(
            Note(
                "A",
        "Hello World",
        Position(0f,0f),
        MyColor.HotPink
        ))
    }
}