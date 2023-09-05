package com.safonov.speedreading.training.fragment.wordpairs.repository;

import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {WordPairsResult.class, WordPairsConfig.class})
public class WordPairsRealmModule {
}
