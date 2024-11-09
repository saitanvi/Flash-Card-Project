package com.example.flashcardapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlashcardAdapter extends RecyclerView.Adapter<FlashcardAdapter.FlashcardViewHolder> {
    private List<Flashcard> flashcards;
    private OnFlashcardClickListener listener;

    public FlashcardAdapter(List<Flashcard> flashcards, OnFlashcardClickListener listener) {
        this.flashcards = flashcards;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FlashcardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flashcard_item, parent, false);
        return new FlashcardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlashcardViewHolder holder, int position) {
        Flashcard flashcard = flashcards.get(position);
        holder.questionText.setText(flashcard.getQuestion());

        // Handle edit and delete actions
        holder.editButton.setOnClickListener(v -> listener.onEditClick(flashcard));
        holder.deleteButton.setOnClickListener(v -> listener.onDeleteClick(flashcard));
    }

    @Override
    public int getItemCount() {
        return flashcards.size();
    }

    public static class FlashcardViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        ImageButton editButton, deleteButton;

        public FlashcardViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }

    public interface OnFlashcardClickListener {
        void onEditClick(Flashcard flashcard);
        void onDeleteClick(Flashcard flashcard);
    }
}
