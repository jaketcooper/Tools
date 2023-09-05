package com.safonov.speedreading.training.fragment.speedreading.repository;

import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {SpeedReadingResult.class, SpeedReadingConfig.class})
public class SpeedReadingRealmModule {
}
