package com.example.mradmin.notesapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.mradmin.notesapp.R;
import com.example.mradmin.notesapp.model.NoteEntity;

import java.util.List;

public class AddNoteActivity extends BaseActivity {

    private ImageButton ibBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        initViews();
    }

    @Override
    protected void initViews() {
        ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //async tasks callbacks
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
