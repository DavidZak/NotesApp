package com.example.mradmin.notesapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.mradmin.notesapp.model.converter.NotePriorityConverter;

@Entity
public class NoteEntity {

    @PrimaryKey
    @NonNull
    private String id;
    private String title;
    private String description;
    private String image;
    @TypeConverters(NotePriorityConverter.class)
    private NotePriority priority;
    private long createdDate;
    private long dueDate;

    public NoteEntity() {

    }

    public NoteEntity(@NonNull String id, String title, String description, String image, NotePriority priority, long createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.priority = priority;
        this.createdDate = createdDate;
    }

    public NoteEntity(@NonNull String id, String title, String description, String image, NotePriority priority, long createdDate, long dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.priority = priority;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public NotePriority getPriority() {
        return priority;
    }

    public void setPriority(NotePriority priority) {
        this.priority = priority;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long date) {
        this.createdDate = date;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", createdDate='" + createdDate +
                ", dueDate='" + dueDate +
                '}';
    }
}
