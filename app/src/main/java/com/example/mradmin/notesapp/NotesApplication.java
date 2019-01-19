package com.example.mradmin.notesapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.mradmin.notesapp.db.AppDatabase;
import com.example.mradmin.notesapp.db.NoteEntityDao;

public class NotesApplication extends Application {

    private static AppDatabase appDatabase;
    private static NoteEntityDao noteEntityDao;

    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(this,
                AppDatabase.class, "room-notes-database").build();

        noteEntityDao = appDatabase.getNoteEntityDao();
    }

    public static NoteEntityDao getNoteEntityDao(){
        return noteEntityDao;
    }
}
