package com.safonov.speedreading.main;

import com.safonov.speedreading.training.TrainingType;

public interface TrainingFragmentListener {
    void requestToStartTraining(TrainingType trainingType);
}
