package com.safonov.speedreading.training.fragment.math.repository;

import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {MathResult.class, MathConfig.class})
public class MathRealmModule {
}
