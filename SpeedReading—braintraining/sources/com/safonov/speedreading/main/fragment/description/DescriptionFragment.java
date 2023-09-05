package com.safonov.speedreading.main.fragment.description;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.speedreading.alexander.speedreading.R;

public class DescriptionFragment extends Fragment {
    @BindView(2131296290)
    AdView adView;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private Unbinder unbinder;

    public static DescriptionFragment newInstance() {
        return new DescriptionFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_description_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (this.premiumUtil.isPremiumUser()) {
            this.adView.setVisibility(8);
        } else {
            this.adView.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    super.onAdLoaded();
                    DescriptionFragment.this.adView.setVisibility(0);
                }

                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    DescriptionFragment.this.adView.setVisibility(8);
                }
            });
            this.adView.loadAd(new AdRequest.Builder().build());
        }
        return view;
    }

    public void onPause() {
        this.adView.pause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.adView.resume();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.adView.destroy();
        this.unbinder.unbind();
    }
}
