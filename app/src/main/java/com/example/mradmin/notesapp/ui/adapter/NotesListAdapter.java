package com.example.mradmin.notesapp.ui.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mradmin.notesapp.R;
import com.example.mradmin.notesapp.model.NoteEntity;
import com.example.mradmin.notesapp.model.NotePriority;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<NoteEntity> data;
    private NotesListAdapterListener listener;

    public NotesListAdapter(Context context, NotesListAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.data = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_note, parent, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NoteViewHolder viewHolder = (NoteViewHolder) holder;
        viewHolder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    private NoteEntity getItem(int position) {
        return this.data.get(position);
    }

    public void setData(List<NoteEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<NoteEntity> data) {
        int positionStart = this.data.size();
        this.data.addAll(data);
        notifyItemRangeInserted(positionStart, data.size());
    }

    public void addData(NoteEntity data) {
        int positionStart = this.data.size();
        this.data.add(data);
        notifyItemInserted(positionStart);
    }

    public void removeData(NoteEntity data) {
        int position = this.data.indexOf(data);
        this.data.remove(data);
        notifyItemRemoved(position);
    }

    public void updateData(NoteEntity data, NoteEntity newData) {
        int position = this.data.indexOf(data);
        this.data.set(position, newData);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.data.clear();
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvDescription;
        private ImageView ivPriority;

        public NoteViewHolder(View itemView) {
            super(itemView);

            this.ivImage = itemView.findViewById(R.id.iv_image);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.tvDescription = itemView.findViewById(R.id.tv_description);
            this.ivPriority = itemView.findViewById(R.id.iv_priority);
        }

        public void bind(final NoteEntity noteEntity) {
            if (noteEntity != null) {
                tvTitle.setText(noteEntity.getTitle());

                tvDescription.setText(noteEntity.getDescription());

                itemView.setOnClickListener(v -> listener.onSelectNote(noteEntity));

                setNotePriorityImage(noteEntity.getPriority());

                if (noteEntity.getImage() != null && !noteEntity.getImage().isEmpty())
                    Picasso.with(this.itemView.getContext())
                            .load(noteEntity.getImage())
                            .placeholder(R.drawable.empty_view_bg_compressed)
                            .error(R.drawable.empty_view_bg_compressed)
                            .into(ivImage);
                else
                    Picasso.with(this.itemView.getContext())
                            .load(R.drawable.empty_view_bg_compressed)
                            .into(ivImage);

            }
        }

        void setNotePriorityImage(NotePriority notePriority) {
            ivPriority.setVisibility(View.VISIBLE);
            switch (notePriority) {
                case NONE:{
                    ivPriority.setVisibility(View.GONE);
                    break;
                }
                case LOW:{
                    ivPriority.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.colorNotePriorityLow), PorterDuff.Mode.SRC_IN);
                    break;
                }
                case MEDIUM:{
                    ivPriority.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.colorNotePriorityMedium), PorterDuff.Mode.SRC_IN);
                    break;
                }
                case HIGH:{
                    ivPriority.setColorFilter(ContextCompat.getColor(itemView.getContext(), R.color.colorNotePriorityHigh), PorterDuff.Mode.SRC_IN);
                    break;
                }
                default:{
                    ivPriority.setVisibility(View.GONE);
                    break;
                }
            }
        }
    }
}
