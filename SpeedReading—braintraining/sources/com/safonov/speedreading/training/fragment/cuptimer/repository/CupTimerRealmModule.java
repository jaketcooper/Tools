package com.safonov.speedreading.training.fragment.cuptimer.repository;

import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {CupTimerResult.class, CupTimerConfig.class})
public class CupTimerRealmModule {
}
