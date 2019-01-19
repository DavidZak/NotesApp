package com.example.mradmin.notesapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mradmin.notesapp.model.NoteEntity;

@Database(entities = {NoteEntity.class /*, AnotherEntityType.class, AThirdEntityType.class */}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteEntityDao getNoteEntityDao();
}
