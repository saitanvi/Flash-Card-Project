package com.example.flashcardapplication;

public class Flashcard {
    private String id;
    private String question;
    private String answer;
    private boolean known;

    public Flashcard(String id, String question, String answer, boolean known) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.known = known;
    }

    // Getters and setters (optional)
    public String getId() { return id; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public boolean isKnown() { return known; }

    public void setId(String id) { this.id = id; }
    public void setQuestion(String question) { this.question = question; }
    public void setAnswer(String answer) { this.answer = answer; }
    public void setKnown(boolean known) { this.known = known; }
}
