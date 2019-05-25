package com.example.mradmin.notesapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mradmin.notesapp.R;
import com.example.mradmin.notesapp.model.NoteEntity;
import com.example.mradmin.notesapp.util.DrawableUtil;

import java.util.List;

public class AddNoteActivity extends BaseActivity {

    //toolbar image buttons
    private ImageButton ibBack;
    private ImageButton ibSave;

    private ImageView ivImage;
    private EditText etTitle;
    private EditText etDescription;
    private EditText etLocation;
    private EditText etDueDate;
    private AppCompatSpinner spinnerPriority;

    private NoteEntity noteEntity = new NoteEntity();

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

        ibSave = findViewById(R.id.ib_save);
        ibSave.setOnClickListener(v -> saveNote());

        ivImage = findViewById(R.id.iv_image);
        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        etLocation = findViewById(R.id.et_location);
        etDueDate = findViewById(R.id.et_date);
        spinnerPriority = findViewById(R.id.spinner_priority);

        DrawableUtil.setVectorForPreLollipop(etLocation, R.drawable.ic_location, this, 1);
        DrawableUtil.setVectorForPreLollipop(etDueDate, R.drawable.ic_date, this, 1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //create new note
    private void saveNote() {

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
