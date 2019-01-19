package com.example.mradmin.notesapp.async_task;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.mradmin.notesapp.db.NoteEntityDao;
import com.example.mradmin.notesapp.model.NoteEntity;

public class AddNoteEntityAsyncTask extends AsyncTask<NoteEntity, Void, Void> {

    private NoteEntityDao noteEntityDao;
    private @NonNull
    NoteEntity noteEntity;
    private AsyncTaskListener listener;

    public AddNoteEntityAsyncTask(NoteEntityDao noteEntityDao, AsyncTaskListener listener, @NonNull NoteEntity noteEntity) {
        this.noteEntityDao = noteEntityDao;
        this.noteEntity = noteEntity;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(NoteEntity... voids) {
        noteEntityDao.insertNote(noteEntity);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(listener != null)
            listener.onAddNote(noteEntity);
    }
}
