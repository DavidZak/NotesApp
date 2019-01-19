package com.example.mradmin.notesapp.model;

public class Note {

    private String id;
    private String title;
    private String description;
    private NotePriority priority;
    private String date;
    private boolean pinned;

    public Note() {
    }

    public Note(String id, String title, String description, NotePriority priority, String date, boolean pinned) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.pinned = pinned;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotePriority getPriority() {
        return priority;
    }

    public void setPriority(NotePriority priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
