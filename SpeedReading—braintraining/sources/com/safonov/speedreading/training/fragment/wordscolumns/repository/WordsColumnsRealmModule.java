package com.safonov.speedreading.training.fragment.wordscolumns.repository;

import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {WordsColumnsResult.class, WordsColumnsConfig.class})
public class WordsColumnsRealmModule {
}
