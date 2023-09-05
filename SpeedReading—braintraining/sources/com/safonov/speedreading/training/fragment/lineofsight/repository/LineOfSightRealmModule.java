package com.safonov.speedreading.training.fragment.lineofsight.repository;

import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {LineOfSightResult.class, LineOfSightConfig.class})
public class LineOfSightRealmModule {
}
