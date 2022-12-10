package com.example.stickynotes

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable

class BoardViewModel(
    private val noteRepository: NoteRepository,
): ViewModel() {
    val allNotes: Observable<List<Note>> = noteRepository.getAll()
}