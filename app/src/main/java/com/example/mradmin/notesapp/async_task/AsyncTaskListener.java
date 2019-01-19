package com.example.mradmin.notesapp.async_task;

import com.example.mradmin.notesapp.model.NoteEntity;

import java.util.List;

public interface AsyncTaskListener {
    void onGetAllNotes(List<NoteEntity> notes);
    void onRemoveNote(NoteEntity note);
    void onAddNote(NoteEntity note);
    void onUpdateNote(NoteEntity note);
}
