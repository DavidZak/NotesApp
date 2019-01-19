package com.example.mradmin.notesapp.async_task;

import android.os.AsyncTask;

import com.example.mradmin.notesapp.db.NoteEntityDao;
import com.example.mradmin.notesapp.model.NoteEntity;

import java.util.List;

public class GetAllNotesAsyncTask extends AsyncTask<Void, Void, List<NoteEntity>> {

    private NoteEntityDao noteEntityDao;
    private AsyncTaskListener listener;

    public GetAllNotesAsyncTask(NoteEntityDao noteEntityDao, AsyncTaskListener listener) {
        this.noteEntityDao = noteEntityDao;
        this.listener = listener;
    }

    @Override
    protected List<NoteEntity> doInBackground(Void... params) {
        return noteEntityDao.getAllNotes();
    }

    @Override
    protected void onPostExecute(List<NoteEntity> notes) {

        if (listener != null)
            listener.onGetAllNotes(notes);
    }
}
