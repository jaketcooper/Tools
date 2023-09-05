package com.safonov.speedreading.training.fragment.flashword.repository;

import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {FlashWordResult.class, FlashWordsConfig.class})
public class FlashWordRealmModule {
}
