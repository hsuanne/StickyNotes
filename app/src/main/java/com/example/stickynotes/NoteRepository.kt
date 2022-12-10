package com.example.stickynotes

import io.reactivex.rxjava3.core.Observable


interface NoteRepository {
    fun getAll(): Observable<List<Note>>
}

class InMemoryNoteRepository(): NoteRepository {
    fun createRandomNote(): Note{ return Note("a", "asdf", Position(0f, 0f), MyColor.HotPink)}

    private val allNotes = listOf(createRandomNote())
    override fun getAll(): Observable<List<Note>> {
        return Observable.just(allNotes)
    }

}