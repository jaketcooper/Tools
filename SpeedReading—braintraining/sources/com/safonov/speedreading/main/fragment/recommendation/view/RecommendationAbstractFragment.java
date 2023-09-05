package com.safonov.speedreading.main.fragment.recommendation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.safonov.speedreading.main.fragment.recommendation.model.Recommendation;
import java.util.List;

public abstract class RecommendationAbstractFragment extends Fragment {
    protected static final String ADVISE_ARRAY_LIST_PARAM = "advice_array_list";
    protected List<Recommendation> recommendationList;
    protected RecyclerView recyclerView;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.recyclerView = new RecyclerView(getContext());
        this.recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.recyclerView.setOverScrollMode(2);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FrameLayout view = new FrameLayout(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        view.addView(this.recyclerView);
        return view;
    }
}
