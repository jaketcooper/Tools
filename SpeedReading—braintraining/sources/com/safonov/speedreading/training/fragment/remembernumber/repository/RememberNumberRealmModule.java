package com.safonov.speedreading.training.fragment.remembernumber.repository;

import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {RememberNumberResult.class, RememberNumberConfig.class})
public class RememberNumberRealmModule {
}
