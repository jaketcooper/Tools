package com.safonov.speedreading.training.fragment.description.view;

import android.content.Context;
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
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.fragment.description.presenter.DescriptionPresenter;
import com.safonov.speedreading.training.fragment.description.presenter.IDescriptionPresenter;
import com.speedreading.alexander.speedreading.R;

public class DescriptionFragment extends MvpFragment<IDescriptionView, IDescriptionPresenter> implements IDescriptionView {
    private static final String TRAINING_FRAGMENT_KEY = "training_fragment_key";
    @BindView(2131296372)
    ScrollView contentHolderScrollView;
    private DescriptionFragmentListener fragmentListener;
    private FragmentType fragmentType;
    private Unbinder unbinder;

    @NonNull
    public IDescriptionPresenter createPresenter() {
        return new DescriptionPresenter(getContext());
    }

    public static DescriptionFragment newInstance(FragmentType fragmentType2) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putSerializable(TRAINING_FRAGMENT_KEY, fragmentType2);
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
        View view = inflater.inflate(R.layout.training_description_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    @OnClick({2131296373})
    public void onStartTrainingClick() {
        this.fragmentListener.onDescriptionFragmentStartClick();
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IDescriptionPresenter) this.presenter).requestToLoadContent(this.fragmentType);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void setContentLayout(@LayoutRes int layout) {
        LayoutInflater.from(getContext()).inflate(layout, this.contentHolderScrollView, true);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DescriptionFragmentListener) {
            this.fragmentListener = (DescriptionFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must DescriptionFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentListener = null;
    }
}
