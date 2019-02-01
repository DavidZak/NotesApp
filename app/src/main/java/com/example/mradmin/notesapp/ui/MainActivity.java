package com.example.mradmin.notesapp.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mradmin.notesapp.NotesApplication;
import com.example.mradmin.notesapp.R;
import com.example.mradmin.notesapp.async_task.AddNoteEntityAsyncTask;
import com.example.mradmin.notesapp.async_task.GetAllNotesAsyncTask;
import com.example.mradmin.notesapp.model.NoteEntity;
import com.example.mradmin.notesapp.model.NotePriority;
import com.example.mradmin.notesapp.ui.adapter.NotesListAdapter;
import com.example.mradmin.notesapp.ui.adapter.NotesListAdapterListener;
import com.example.mradmin.notesapp.util.NavigationUtil;
import com.example.mradmin.notesapp.view.RecyclerSectionItemDecoration;
import com.example.mradmin.notesapp.view.RecyclerViewEmptySupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity implements NotesListAdapterListener {

    private LinearLayout llEmptyNotesList;
    private RecyclerViewEmptySupport rvNotesList;
    private NotesListAdapter adapter;
    private ImageButton ibAdd;

    private List<NoteEntity> allNotes = new ArrayList<>();

    private GetAllNotesAsyncTask getAllNotesAsyncTask;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");

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
    protected void onDestroy() {
        super.onDestroy();

        if(getAllNotesAsyncTask != null && !getAllNotesAsyncTask.isCancelled()) {
            getAllNotesAsyncTask.cancel(true);
            getAllNotesAsyncTask = null;
        }
    }

    @Override
    protected void initViews() {
        llEmptyNotesList = findViewById(R.id.ll_notes_empty);
        rvNotesList = findViewById(R.id.rv_notes_list);
        rvNotesList.setEmptyView(llEmptyNotesList);
        ibAdd = findViewById(R.id.ib_add);
        ibAdd.setOnClickListener(v -> {
            NavigationUtil.startActivitySingleTop(this, AddNoteActivity.class);
        });
    }

    private void initAdapter() {
        adapter = new NotesListAdapter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvNotesList.setLayoutManager(linearLayoutManager);
        rvNotesList.setAdapter(adapter);
        initRecyclerItemSectionDecoration(rvNotesList, allNotes);
    }

    //init recycler section decoration
    public void initRecyclerItemSectionDecoration(RecyclerView recyclerView, List<NoteEntity> noteEntities){
        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.header_height),
                        true,
                        getSectionCallback(noteEntities));
        recyclerView.addItemDecoration(sectionItemDecoration);
    }

    //check contains note
    private NoteEntity containsIndex(List<NoteEntity> list, int index)  {
        try {
            return list.get(index);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    //recycler section decoration callback
    private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final List<NoteEntity> notes) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int position) {

                if (containsIndex(notes, position) == null)
                    return position == 0;
                else
                    return position == 0
                            ||  !(simpleDateFormat.format(new Date(notes.get(position).getDate())).equals(simpleDateFormat.format(new Date(notes.get(position - 1).getDate()))));
            }

            @Override
            public CharSequence getSectionHeader(int position) {
                if (containsIndex(notes, position) == null)
                    return "";
                else
                    return simpleDateFormat.format(new Date(notes.get(position).getDate()));
            }
        };
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
        allNotes.add(new NoteEntity("1", "qwe", "rty", "", NotePriority.HIGH, System.currentTimeMillis()));
        allNotes.add(new NoteEntity("2", "qwe22", "rty", "", NotePriority.LOW, System.currentTimeMillis()));
        allNotes.add(new NoteEntity("3", "qwe33", "rty", "", NotePriority.MEDIUM, System.currentTimeMillis() / 2000));
        allNotes.add(new NoteEntity("4", "qwe44", "rty", "", NotePriority.NONE, System.currentTimeMillis() / 5000));
        allNotes.add(new NoteEntity("5", "qwe", "rty", "", NotePriority.HIGH, System.currentTimeMillis()));
        allNotes.add(new NoteEntity("6", "qwe22", "rty", "", NotePriority.LOW, System.currentTimeMillis() / 8000));
        allNotes.add(new NoteEntity("7", "qwe33", "rty", "", NotePriority.MEDIUM, System.currentTimeMillis() / 3000));
        allNotes.add(new NoteEntity("8", "qwe44", "rty", "", NotePriority.NONE, System.currentTimeMillis()));
        allNotes.add(new NoteEntity("9", "qwe", "rty", "", NotePriority.HIGH, System.currentTimeMillis()));
        allNotes.add(new NoteEntity("10", "qwe22", "rty", "", NotePriority.LOW, System.currentTimeMillis() / 1000));
        allNotes.add(new NoteEntity("11", "qwe33", "rty", "", NotePriority.MEDIUM, System.currentTimeMillis()));
        allNotes.add(new NoteEntity("12", "qwe44", "rty", "", NotePriority.NONE, System.currentTimeMillis() / 6000));
        adapter.addData(allNotes);
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
