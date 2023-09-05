package com.safonov.speedreading.training.fragment.greendot.repository;

import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {GreenDotResult.class, GreenDotConfig.class})
public class GreenDotRealmModule {
}
