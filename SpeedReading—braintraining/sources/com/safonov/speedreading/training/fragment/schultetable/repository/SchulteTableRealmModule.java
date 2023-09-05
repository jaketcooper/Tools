package com.safonov.speedreading.training.fragment.schultetable.repository;

import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import p006io.realm.annotations.RealmModule;

@RealmModule(classes = {SchulteTableResult.class, SchulteTableConfig.class})
public class SchulteTableRealmModule {
}
