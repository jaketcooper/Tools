package com.safonov.speedreading.main.activity.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.main.MenuFragmentListener;
import com.safonov.speedreading.main.TrainingFragmentListener;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface IMenuView extends MvpView, MenuFragmentListener, TrainingFragmentListener {
    void finish();

    void onFileExplorerBackPressed();

    void setAcceleratorTrainingMenuFragment();

    void setActionBarItemsVisible(boolean z);

    void setBookDetailFragment(BookDescription bookDescription);

    void setDescriptionFragment();

    void setFileExplorerFragment();

    void setLibraryFragment();

    void setMainMenuFragment();

    void setMotivatorsFragment();

    void setMotivatorsMenuFragment();

    void setProfileFragment();

    void setRecommendationFragment();

    void setRulesOfSuccessFragment();

    void setSettingsFragment();

    void setTrainingMenuFragment();
}
