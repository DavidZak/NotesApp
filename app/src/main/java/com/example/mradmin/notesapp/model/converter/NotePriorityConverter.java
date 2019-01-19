package com.example.mradmin.notesapp.model.converter;

import android.arch.persistence.room.TypeConverter;

import com.example.mradmin.notesapp.model.NotePriority;

public class NotePriorityConverter {

    @TypeConverter
    public static NotePriority toNotePriority(int status) {
        if (status == NotePriority.NONE.getCode()) {
            return NotePriority.NONE;
        } else if (status == NotePriority.LOW.getCode()) {
            return NotePriority.LOW;
        } else if (status == NotePriority.MEDIUM.getCode()) {
            return NotePriority.MEDIUM;
        } else if (status == NotePriority.HIGH.getCode()) {
            return NotePriority.HIGH;
        } else {
            throw new IllegalArgumentException("Could not recognize priority");
        }
    }

    @TypeConverter
    public static int toInteger(NotePriority notePriority) {
        return notePriority.getCode();
    }

}
