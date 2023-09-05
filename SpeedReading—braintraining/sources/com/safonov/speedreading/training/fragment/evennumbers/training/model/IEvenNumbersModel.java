package com.safonov.speedreading.training.fragment.evennumbers.training.model;

import android.support.annotation.NonNull;
import java.util.List;

public interface IEvenNumbersModel {
    @NonNull
    List<NumberWrapper> createItems(int i, int i2, int i3);
}
