package com.safonov.speedreading.main.activity.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.main.MenuFragmentType;
import com.safonov.speedreading.main.activity.view.IMenuView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public class MenuPresenter extends MvpBasePresenter<IMenuView> implements IMenuPresenter {
    private MenuFragmentType menuFragmentType;

    public void requestToSetFragment(MenuFragmentType menuFragmentType2) {
        this.menuFragmentType = menuFragmentType2;
        switch (menuFragmentType2) {
            case MAIN_MENU:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(true);
                    ((IMenuView) getView()).setMainMenuFragment();
                    return;
                }
                return;
            case SETTINGS:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setSettingsFragment();
                    return;
                }
                return;
            case DESCRIPTION:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setDescriptionFragment();
                    return;
                }
                return;
            case TRAINING_MENU:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setTrainingMenuFragment();
                    return;
                }
                return;
            case ACCELERATOR_MENU:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setAcceleratorTrainingMenuFragment();
                    return;
                }
                return;
            case MOTIVATORS_MENU:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setMotivatorsMenuFragment();
                    return;
                }
                return;
            case MOTIVATORS:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setMotivatorsFragment();
                    return;
                }
                return;
            case RULES_OF_SUCCESS:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setRulesOfSuccessFragment();
                    return;
                }
                return;
            case RECOMMENDATION:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setRecommendationFragment();
                    return;
                }
                return;
            case PROFILE:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setProfileFragment();
                    return;
                }
                return;
            case LIBRARY:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setLibraryFragment();
                    return;
                }
                return;
            case FILE_EXPLORER:
                if (isViewAttached()) {
                    ((IMenuView) getView()).setActionBarItemsVisible(false);
                    ((IMenuView) getView()).setFileExplorerFragment();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (this.menuFragmentType == MenuFragmentType.FILE_EXPLORER) {
            ((IMenuView) getView()).onFileExplorerBackPressed();
            return;
        }
        this.menuFragmentType = this.menuFragmentType.getParent();
        if (this.menuFragmentType != null) {
            requestToSetFragment(this.menuFragmentType);
        } else if (isViewAttached()) {
            ((IMenuView) getView()).finish();
        }
    }

    public void onActionBarHomePressed() {
        this.menuFragmentType = this.menuFragmentType.getParent();
        if (this.menuFragmentType != null) {
            requestToSetFragment(this.menuFragmentType);
        } else if (isViewAttached()) {
            ((IMenuView) getView()).finish();
        }
    }

    public void requestToSetBookDetailFragment(BookDescription bookDescription) {
        requestToSetFragment(MenuFragmentType.BOOK_DETAIL);
        if (isViewAttached()) {
            ((IMenuView) getView()).setBookDetailFragment(bookDescription);
        }
    }

    public void onActionBarSettingsPressed() {
        requestToSetFragment(MenuFragmentType.SETTINGS);
    }

    public void onActionBarHelpPressed() {
        requestToSetFragment(MenuFragmentType.DESCRIPTION);
    }
}
