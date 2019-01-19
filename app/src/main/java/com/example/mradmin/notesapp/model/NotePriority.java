package com.example.mradmin.notesapp.model;

public enum NotePriority {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int code;

    NotePriority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
