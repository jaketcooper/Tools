package com.safonov.speedreading.training.activity.model.entity;

import com.safonov.speedreading.training.FragmentType;
import java.util.List;

public class TrainingWrapper {
    private final ConfigWrapper configWrapper;
    private final List<FragmentType> fragmentTypeList;

    public TrainingWrapper(ConfigWrapper configWrapper2, List<FragmentType> fragmentTypeList2) {
        this.configWrapper = configWrapper2;
        this.fragmentTypeList = fragmentTypeList2;
    }

    public ConfigWrapper getConfigWrapper() {
        return this.configWrapper;
    }

    public List<FragmentType> getFragmentTypeList() {
        return this.fragmentTypeList;
    }
}
