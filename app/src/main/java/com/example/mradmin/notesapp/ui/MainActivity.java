package com.example.mradmin.notesapp.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.mradmin.notesapp.NotesApplication;
import com.example.mradmin.notesapp.R;
import com.example.mradmin.notesapp.async_task.AddNoteEntityAsyncTask;
import com.example.mradmin.notesapp.async_task.GetAllNotesAsyncTask;
import com.example.mradmin.notesapp.model.NoteEntity;
import com.example.mradmin.notesapp.model.NotePriority;
import com.example.mradmin.notesapp.ui.adapter.NotesListAdapter;
import com.example.mradmin.notesapp.ui.adapter.NotesListAdapterListener;
import com.example.mradmin.notesapp.view.RecyclerViewEmptySupport;

import java.util.List;

public class MainActivity extends BaseActivity implements NotesListAdapterListener {

    private LinearLayout llEmptyNotesList;
    private RecyclerViewEmptySupport rvNotesList;
    private NotesListAdapter adapter;

    private GetAllNotesAsyncTask getAllNotesAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNotesList();
    }

    @Override
    protected void initViews() {
        llEmptyNotesList = findViewById(R.id.ll_notes_empty);
        rvNotesList = findViewById(R.id.rv_notes_list);
        rvNotesList.setEmptyView(llEmptyNotesList);
    }

    private void initAdapter() {
        adapter = new NotesListAdapter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvNotesList.setLayoutManager(linearLayoutManager);
        rvNotesList.setAdapter(adapter);
    }

    //db requests
    private void getNotesList() {
        getAllNotesAsyncTask = new GetAllNotesAsyncTask(NotesApplication.getNoteEntityDao(), this);
        getAllNotesAsyncTask.execute();
    }

    //async tasks callbacks
    @Override
    public void onGetAllNotes(List<NoteEntity> notes) {
        System.out.println("-------------------------- notes list: " + notes);
        adapter.addData(new NoteEntity("1", "qwe", "rty", "", NotePriority.HIGH, ""));
        adapter.addData(new NoteEntity("2", "qwe22", "rty", "", NotePriority.LOW, ""));
        adapter.addData(new NoteEntity("3", "qwe33", "rty", "", NotePriority.MEDIUM, ""));
        adapter.addData(new NoteEntity("1", "qwe44", "rty", "", NotePriority.NONE, ""));
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

    //adapter callback
    @Override
    public void onSelectNote(NoteEntity noteEntity) {

    }
}
