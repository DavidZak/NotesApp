package com.example.mradmin.notesapp.async_task;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.mradmin.notesapp.db.NoteEntityDao;
import com.example.mradmin.notesapp.model.NoteEntity;

public class RemoveNoteEntityAsyncTask extends AsyncTask<NoteEntity, Void, Void> {

    private NoteEntityDao noteEntityDao;
    private @NonNull
    NoteEntity noteEntity;
    private AsyncTaskListener listener;

    public RemoveNoteEntityAsyncTask(NoteEntityDao noteEntityDao, AsyncTaskListener listener, @NonNull NoteEntity noteEntity) {
        this.noteEntityDao = noteEntityDao;
        this.noteEntity = noteEntity;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(NoteEntity... params) {
        noteEntityDao.delete(noteEntity);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        listener.onRemoveNote(noteEntity);
    }
}
