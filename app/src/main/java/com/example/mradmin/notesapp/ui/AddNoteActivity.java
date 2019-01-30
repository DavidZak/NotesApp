package com.example.mradmin.notesapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mradmin.notesapp.R;
import com.example.mradmin.notesapp.model.NoteEntity;

import java.util.List;

public class AddNoteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }

    @Override
    protected void initViews() {

    }

    @Override
    public void onGetAllNotes(List<NoteEntity> notes) {

    }

    @Override
    public void onRemoveNote(NoteEntity note) {

    }

    @Override
    public void onAddNote(NoteEntity note) {

    }

    @Override
    public void onUpdateNote(NoteEntity note) {

    }
}
