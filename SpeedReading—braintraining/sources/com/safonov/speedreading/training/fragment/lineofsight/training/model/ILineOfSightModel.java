package com.safonov.speedreading.training.fragment.lineofsight.training.model;

import java.util.List;

public interface ILineOfSightModel {
    List<String> getCheckedItems(int i, boolean z);

    List<String> getItems(int i, int i2);

    boolean nextIsMistake(int i);
}
