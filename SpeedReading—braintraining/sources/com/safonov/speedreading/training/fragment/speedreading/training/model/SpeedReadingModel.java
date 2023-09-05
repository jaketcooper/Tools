package com.safonov.speedreading.training.fragment.speedreading.training.model;

import android.content.Context;
import com.safonov.speedreading.training.fragment.speedreading.util.IndexesUtil;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class SpeedReadingModel implements ISpeedReadingModel {
    private String[] words;

    public SpeedReadingModel(Context context) {
        this.words = context.getResources().getStringArray(R.array.speed_reading_words);
    }

    public List<String> createItems(int itemsCount) {
        List<String> result = new ArrayList<>(itemsCount);
        for (int index : IndexesUtil.generateUniqueIndexes(this.words.length - 1, itemsCount)) {
            result.add(this.words[index]);
        }
        return result;
    }
}
