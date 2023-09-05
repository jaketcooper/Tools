package com.safonov.speedreading.training.fragment.lineofsight.training.model;

import android.content.Context;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineOfSightModel implements ILineOfSightModel {
    private static final String CENTER_VALUE = "•";
    private static final int MAX_PROBABILITY = 100;
    private String[] alphabet;
    private Random random = new Random();

    public LineOfSightModel(Context context) {
        this.alphabet = context.getResources().getStringArray(R.array.line_of_sight_alphabet);
    }

    public List<String> getItems(int rowCount, int columnCount) {
        int itemCount = rowCount * columnCount;
        int center = itemCount / 2;
        List<String> itemList = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            if (i == center) {
                itemList.add(CENTER_VALUE);
            } else {
                itemList.add(this.alphabet[this.random.nextInt(this.alphabet.length)]);
            }
        }
        return itemList;
    }

    public List<String> getCheckedItems(int checkedItemCount, boolean areAllEqual) {
        List<String> checkedItemList = new ArrayList<>(checkedItemCount);
        String letter = this.alphabet[this.random.nextInt(this.alphabet.length)];
        for (int i = 0; i < checkedItemCount; i++) {
            checkedItemList.add(letter);
        }
        if (!areAllEqual) {
            checkedItemList.set(this.random.nextInt(checkedItemCount), this.alphabet[this.random.nextInt(this.alphabet.length)]);
        }
        return checkedItemList;
    }

    public boolean nextIsMistake(int mistakeProbability) {
        return this.random.nextInt(101) <= mistakeProbability;
    }
}
