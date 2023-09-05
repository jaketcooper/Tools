package com.safonov.speedreading.training.fragment.rememberwords.repository;

import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {RememberWordsResult.class, RememberWordsConfig.class})
public class RememberWordsRealmModule {
}
