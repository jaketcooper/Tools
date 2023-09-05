package com.safonov.speedreading.training.fragment.wordsblock.repository;

import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {WordBlockResult.class, WordBlockConfig.class})
public class WordBlockRealmModule {
}
