package com.safonov.speedreading.training.fragment.wordpairs.training.model;

import android.content.Context;
import android.support.annotation.NonNull;
import com.speedreading.alexander.speedreading.R;
import java.util.List;

public class WordPairsModel implements IWordPairsModel {
    private String[] firstWords;
    private String[] secondWords;
    private String[] words;

    public WordPairsModel(@NonNull Context context) {
        this.words = context.getResources().getStringArray(R.array.word_pairs_words);
        this.firstWords = context.getResources().getStringArray(R.array.word_pairs_non_equal_first_words);
        this.secondWords = context.getResources().getStringArray(R.array.word_pairs_non_equal_second_words);
    }

    public List<WordPair> createWordPairs(int wordPairsCountCount, int differentWordPairsCount) {
        return WordPairsGenerator.createWordPairs(this.words, this.firstWords, this.secondWords, wordPairsCountCount, differentWordPairsCount);
    }
}
