package com.safonov.speedreading.main.fragment.motivators.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentStatePagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.speedreading.alexander.speedreading.R;
import java.util.Random;

public class MotivatorsFragment extends Fragment {
    @BindView(2131296290)
    AdView adView;
    @BindArray(2130903060)
    String[] motivatorMessageArray;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private Unbinder unbinder;
    @BindView(2131296835)
    ViewPager viewPager;

    public static MotivatorsFragment newInstance() {
        return new MotivatorsFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.motivators_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.viewPager.setAdapter(new MotivatorsAdapter(getFragmentManager(), this.motivatorMessageArray));
        this.viewPager.setCurrentItem(12);
        if (this.premiumUtil.isPremiumUser()) {
            this.adView.setVisibility(8);
        } else {
            this.adView.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    super.onAdLoaded();
                    MotivatorsFragment.this.adView.setVisibility(0);
                }

                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    MotivatorsFragment.this.adView.setVisibility(8);
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

    private class MotivatorsAdapter extends FragmentStatePagerAdapter {
        public static final int ITEMS_COUNT = 25;
        private String[] messages;
        private Random random;

        private MotivatorsAdapter(FragmentManager fm, String[] messages2) {
            super(fm);
            this.random = new Random();
            this.messages = messages2;
        }

        public Fragment getItem(int position) {
            return MotivatorPageFragment.newInstance(this.messages[this.random.nextInt(this.messages.length)]);
        }

        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }

    public static class MotivatorPageFragment extends Fragment {
        public static final String MOTIVATORS_MESSAGE_PARAM = "motivators_message";
        private String motivatorsMessage;

        public static MotivatorPageFragment newInstance(String text) {
            MotivatorPageFragment fragment = new MotivatorPageFragment();
            Bundle args = new Bundle();
            args.putString(MOTIVATORS_MESSAGE_PARAM, text);
            fragment.setArguments(args);
            return fragment;
        }

        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                this.motivatorsMessage = getArguments().getString(MOTIVATORS_MESSAGE_PARAM);
            }
        }

        @Nullable
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.motivators_view_pager_fragment, container, false);
            ((TextView) ButterKnife.findById(view, (int) R.id.motivators_message_text_view)).setText(this.motivatorsMessage);
            return view;
        }
    }
}
