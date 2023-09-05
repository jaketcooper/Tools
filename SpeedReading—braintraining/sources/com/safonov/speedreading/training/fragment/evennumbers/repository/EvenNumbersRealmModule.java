package com.safonov.speedreading.training.fragment.evennumbers.repository;

import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {EvenNumbersResult.class, EvenNumbersConfig.class})
public class EvenNumbersRealmModule {
}
