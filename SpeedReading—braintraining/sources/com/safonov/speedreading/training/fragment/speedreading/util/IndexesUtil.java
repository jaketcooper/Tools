package com.safonov.speedreading.training.fragment.speedreading.util;

import android.support.annotation.NonNull;
import java.util.Arrays;
import java.util.Random;

public class IndexesUtil {
    private static final Random random = new Random();

    public static int[] generateUniqueIndexes(int maxIndexValue, int uniqueIndexesCount) {
        int[] result = new int[uniqueIndexesCount];
        Arrays.fill(result, -1);
        int index = 0;
        while (index < uniqueIndexesCount) {
            int randomIndex = random.nextInt(maxIndexValue + 1);
            if (!containsInArray(result, randomIndex)) {
                result[index] = randomIndex;
                index++;
            }
        }
        return result;
    }

    private static boolean containsInArray(@NonNull int[] array, int checkedItem) {
        for (int item : array) {
            if (checkedItem == item) {
                return true;
            }
        }
        return false;
    }
}
