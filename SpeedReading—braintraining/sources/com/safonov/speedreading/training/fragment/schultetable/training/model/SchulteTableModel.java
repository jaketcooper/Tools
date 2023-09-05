package com.safonov.speedreading.training.fragment.schultetable.training.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchulteTableModel implements ISchulteTableModel {
    public List<String> getRandomNumbers(int itemCount) {
        List<String> result = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            result.add(String.valueOf(i + 1));
        }
        Collections.shuffle(result);
        return result;
    }

    public String getNextNumberItem(String currentItem, int itemCount) {
        int number = Integer.valueOf(currentItem).intValue();
        if (number < itemCount) {
            return String.valueOf(number + 1);
        }
        return null;
    }
}
