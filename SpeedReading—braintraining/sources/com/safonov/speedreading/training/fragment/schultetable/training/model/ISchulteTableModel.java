package com.safonov.speedreading.training.fragment.schultetable.training.model;

import java.util.List;

public interface ISchulteTableModel {
    String getNextNumberItem(String str, int i);

    List<String> getRandomNumbers(int i);
}
