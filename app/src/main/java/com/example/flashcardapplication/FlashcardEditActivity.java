package com.example.flashcardapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FlashcardEditActivity extends AppCompatActivity {
    private EditText questionInput, answerInput;
    private Button saveButton;
    private DatabaseReference flashcardRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_edit);

        questionInput = findViewById(R.id.questionInput);
        answerInput = findViewById(R.id.answerInput);
        saveButton = findViewById(R.id.saveButton);

        // Firebase database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        flashcardRef = database.getReference("Flashcards");

        saveButton.setOnClickListener(v -> saveFlashcard());
    }

    private void saveFlashcard() {
        String question = questionInput.getText().toString().trim();
        String answer = answerInput.getText().toString().trim();

        if (!question.isEmpty() && !answer.isEmpty()) {
            String flashcardId = flashcardRef.push().getKey();
            Flashcard flashcard = new Flashcard(flashcardId, question, answer, false);
            flashcardRef.child(flashcardId).setValue(flashcard)
                    .addOnSuccessListener(aVoid -> Toast.makeText(this, "Flashcard saved", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(this, "Failed to save flashcard", Toast.LENGTH_SHORT).show());
        } else {
            Toast.makeText(this, "Please enter both question and answer", Toast.LENGTH_SHORT).show();
        }
    }
}
