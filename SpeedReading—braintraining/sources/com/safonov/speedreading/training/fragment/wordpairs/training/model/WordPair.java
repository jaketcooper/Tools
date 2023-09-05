package com.safonov.speedreading.training.fragment.wordpairs.training.model;

public class WordPair {
    private boolean areWordsEqual;
    private String firstWord;
    private String secondWord;

    public WordPair(String firstWord2, String secondWord2) {
        this.firstWord = firstWord2;
        this.secondWord = secondWord2;
        if (firstWord2 == null || secondWord2 == null) {
            this.areWordsEqual = false;
        } else if (firstWord2.equals(secondWord2)) {
            this.areWordsEqual = true;
        }
    }

    public boolean areWordsEqual() {
        return this.areWordsEqual;
    }

    public String getFirstWord() {
        return this.firstWord;
    }

    public String getSecondWord() {
        return this.secondWord;
    }
}
