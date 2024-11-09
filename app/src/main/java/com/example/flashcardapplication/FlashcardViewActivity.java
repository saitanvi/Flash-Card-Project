package com.example.flashcardapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FlashcardViewActivity extends AppCompatActivity {
    private TextView questionView, answerView;
    private Button knownButton, shuffleButton;
    private boolean showingAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_view);

        questionView = findViewById(R.id.questionView);
        answerView = findViewById(R.id.answerView);
        knownButton = findViewById(R.id.knownButton);
        shuffleButton = findViewById(R.id.shuffleButton);

        questionView.setOnClickListener(v -> flipCard());

        shuffleButton.setOnClickListener(v -> shuffleFlashcards());
        knownButton.setOnClickListener(v -> markAsKnown());
    }

    private void flipCard() {
        // Simple flip animation logic to toggle question and answer visibility
        if (showingAnswer) {
            questionView.setVisibility(View.VISIBLE);
            answerView.setVisibility(View.GONE);
        } else {
            questionView.setVisibility(View.GONE);
            answerView.setVisibility(View.VISIBLE);
        }
        showingAnswer = !showingAnswer;
    }

    private void markAsKnown() {
        // Firebase code to mark flashcard as known
    }

    private void shuffleFlashcards() {
        // Logic to shuffle flashcards
    }
}
