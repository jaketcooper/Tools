package com.safonov.speedreading.main.fragment.recommendation.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.main.fragment.recommendation.RecommendationAdapter;
import com.safonov.speedreading.main.fragment.recommendation.model.Recommendation;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;

public class RecomendationFragment extends RecommendationAbstractFragment {
    private RecommendationAdapter recommendationAdapter;
    /* access modifiers changed from: private */
    public ArrayList<Recommendation> recommendationList;

    public static RecomendationFragment newInstance() {
        return new RecomendationFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        String[] recommendationTitleArray = App.get().getResources().getStringArray(R.array.recommendation_services_title);
        String[] recommendatioMessageArray = App.get().getResources().getStringArray(R.array.recommendation_services_description);
        String[] recommendationLinkArray = App.get().getResources().getStringArray(R.array.recommendation_services_link);
        this.recommendationList = new ArrayList<>(recommendationTitleArray.length);
        for (int i = 0; i < recommendationTitleArray.length; i++) {
            this.recommendationList.add(new Recommendation(recommendationTitleArray[i], recommendatioMessageArray[i], recommendationLinkArray[i]));
        }
        this.recommendationAdapter = new RecommendationAdapter(new RecommendationAdapter.OnItemClickListener() {
            public void onItemClick(int position) {
                RecomendationFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((Recommendation) RecomendationFragment.this.recommendationList.get(position)).getLink())));
            }
        });
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setAdapter(this.recommendationAdapter);
        this.recommendationAdapter.setItems(this.recommendationList);
        return view;
    }
}
