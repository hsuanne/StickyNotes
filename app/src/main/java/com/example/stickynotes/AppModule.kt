package com.example.stickynotes

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<NoteRepository> { InMemoryNoteRepository() }
    viewModel { BoardViewModel(get()) }
}