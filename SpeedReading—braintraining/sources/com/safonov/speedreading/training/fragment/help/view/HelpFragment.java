package com.safonov.speedreading.training.fragment.help.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.fragment.help.presenter.HelpPresenter;
import com.safonov.speedreading.training.fragment.help.presenter.IHelpPresenter;
import com.speedreading.alexander.speedreading.R;

public class HelpFragment extends MvpFragment<IHelpView, IHelpPresenter> implements IHelpView {
    private static final String TRAINING_FRAGMENT_KEY = "training_fragment_key";
    @BindView(2131296426)
    ScrollView contentHolderScrollView;
    private FragmentType fragmentType;
    private Unbinder unbinder;

    @NonNull
    public IHelpPresenter createPresenter() {
        return new HelpPresenter();
    }

    public static HelpFragment newInstance(FragmentType helpFragmentType) {
        HelpFragment fragment = new HelpFragment();
        Bundle args = new Bundle();
        args.putSerializable(TRAINING_FRAGMENT_KEY, helpFragmentType);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.fragmentType = (FragmentType) getArguments().getSerializable(TRAINING_FRAGMENT_KEY);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IHelpPresenter) this.presenter).requestToLoadContent(this.fragmentType);
    }

    public void onDestroy() {
        super.onDestroy();
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }

    public void setContentLayout(@LayoutRes int layout) {
        LayoutInflater.from(getContext()).inflate(layout, this.contentHolderScrollView, true);
    }
}
