package com.safonov.speedreading.training.fragment.evennumbers.training.model;

import android.support.annotation.NonNull;
import java.util.List;

public class EvenNumbersModel implements IEvenNumbersModel {
    @NonNull
    public List<NumberWrapper> createItems(int itemsCount, int evenNumbersCount, int digitPerNumber) {
        return NumberWrapperGenerator.createNumberWrappers(digitPerNumber, itemsCount, evenNumbersCount);
    }
}
