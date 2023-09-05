package com.safonov.speedreading.training.fragment.concentration.repository;

import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {ConcentrationResult.class, ConcentrationConfig.class})
public class ConcentrationRealmModule {
}
