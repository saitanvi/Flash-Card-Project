package com.example.flashcardapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity implements FlashcardAdapter.OnFlashcardClickListener {
    private RecyclerView recyclerView;
    private FlashcardAdapter adapter;
    private FloatingActionButton addButton;
    private List<Flashcard> flashcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);

        // Initialize an empty list for flashcards; populate it with data from Firebase as needed.
        flashcards = new ArrayList<>();

        // Set up RecyclerView with the adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FlashcardAdapter(flashcards, this); // Pass the list and this activity as the listener
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, FlashcardEditActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onEditClick(Flashcard flashcard) {
        // Navigate to the edit screen, passing the flashcard ID for editing.
        Intent intent = new Intent(this, FlashcardEditActivity.class);
        intent.putExtra("flashcardId", flashcard.getId());
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Flashcard flashcard) {
        // Delete the flashcard and update the UI
        flashcards.remove(flashcard);  // Remove locally
        adapter.notifyDataSetChanged(); // Notify adapter of data change
        // Additional deletion from Firebase or other persistence, if applicable
    }
}
