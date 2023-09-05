package com.safonov.speedreading.training.fragment.truecolors.repository;

import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {TrueColorsResult.class, TrueColorsConfig.class})
public class TrueColorsRealmModule {
}
