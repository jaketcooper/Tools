package com.safonov.speedreading.training.fragment.wordpairs.training.model;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class WordPairsGenerator {
    private static Random random = new Random();

    WordPairsGenerator() {
    }

    static List<WordPair> createWordPairs(@NonNull String[] words, @NonNull String[] firstWords, @NonNull String[] secondWords, int wordPairsCount, int differentWordPairsCount) {
        if (differentWordPairsCount > wordPairsCount) {
            throw new IllegalArgumentException("differentWordPairsCount must be no more than wordPairsCount");
        } else if (words.length < wordPairsCount - differentWordPairsCount) {
            throw new IllegalArgumentException("words array must not be no less than wordPairsCount - differentWordPairsCount");
        } else if (firstWords.length < differentWordPairsCount) {
            throw new IllegalArgumentException("firstWords array must be more than differentWordPairsCount");
        } else if (secondWords.length < differentWordPairsCount) {
            throw new IllegalArgumentException("secondWords array must be more than differentWordPairsCount");
        } else if (firstWords.length != secondWords.length) {
            throw new IllegalArgumentException("firstWords array must have same length as secondWords");
        } else {
            int equalPairsCount = wordPairsCount - differentWordPairsCount;
            int[] equalWordPairsIndexes = getUniqueIndexes(words.length, equalPairsCount);
            int differentWordsCount = firstWords.length;
            int[] differentWordIndexes = getUniqueIndexes(differentWordsCount, differentWordsCount);
            List<WordPair> wordPairs = new ArrayList<>(wordPairsCount);
            for (int i = 0; i < equalPairsCount; i++) {
                String word = words[equalWordPairsIndexes[i]];
                wordPairs.add(new WordPair(word, word));
            }
            for (int i2 = 0; i2 < differentWordPairsCount; i2++) {
                int currentIndex = differentWordIndexes[i2];
                wordPairs.add(new WordPair(firstWords[currentIndex], secondWords[currentIndex]));
            }
            Collections.shuffle(wordPairs);
            return wordPairs;
        }
    }

    private static int[] getUniqueIndexes(int length, int uniqueIndexCount) {
        int[] result = new int[uniqueIndexCount];
        Arrays.fill(result, -1);
        int index = 0;
        while (index < uniqueIndexCount) {
            int randomIndex = random.nextInt(length);
            if (!containsInArray(result, randomIndex)) {
                result[index] = randomIndex;
                index++;
            }
        }
        return result;
    }

    private static boolean containsInArray(@NonNull int[] array, int item) {
        for (int arrayItem : array) {
            if (item == arrayItem) {
                return true;
            }
        }
        return false;
    }
}
