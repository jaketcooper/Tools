package com.safonov.speedreading.main.fragment.profile.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.main.MenuFragmentListener;
import com.safonov.speedreading.main.MenuFragmentType;
import com.safonov.speedreading.main.fragment.mainmenu.view.PassCourseRatingState;
import com.safonov.speedreading.training.fragment.passcource.repository.PassCourseRealmUtil;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import com.speedreading.alexander.speedreading.R;

public class ProfileFragment extends Fragment {
    private MenuFragmentListener fragmentListener;
    private PassCourseRealmUtil passCourseRealmUtil;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    @BindView(2131296586)
    TextView profileRatingTv;
    @BindView(2131296589)
    TextView profileTypeTV;
    private Unbinder unbinder;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    private PassCourseRatingState getRatingState(int score) {
        if (score >= 1000) {
            return PassCourseRatingState.GENIUS;
        }
        if (score >= 900) {
            return PassCourseRatingState.PROFESSOR;
        }
        if (score >= 750) {
            return PassCourseRatingState.GURU;
        }
        if (score >= 650) {
            return PassCourseRatingState.MASTER;
        }
        if (score >= 500) {
            return PassCourseRatingState.EXPERT;
        }
        if (score >= 350) {
            return PassCourseRatingState.LEARNER;
        }
        return PassCourseRatingState.BEGINNER;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.passCourseRealmUtil = new PassCourseRealmUtil(App.get().getPassCourseConfiguration());
        PassCourseResult bestResult = this.passCourseRealmUtil.getBestResult();
        if (bestResult == null) {
            this.profileRatingTv.setText(getString(PassCourseRatingState.BEGINNER.getTitleRes()));
        } else {
            this.profileRatingTv.setText(getString(getRatingState(bestResult.getScore()).getTitleRes()));
        }
        if (this.premiumUtil.isPremiumUser()) {
            this.profileTypeTV.setText(R.string.premium);
            this.profileTypeTV.setBackgroundResource(R.drawable.rounded_premium_shape);
        }
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MenuFragmentListener) {
            this.fragmentListener = (MenuFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement MenuFragmentListener");
    }

    @OnClick({2131296583})
    public void onPrivacyPolicyClick() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://speedreadingteam.com/privacy_policy.html")));
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentListener = null;
    }

    @OnClick({2131296587})
    public void onSettingsStart() {
        this.fragmentListener.requestToSetFragment(MenuFragmentType.SETTINGS);
    }

    @OnClick({2131296588})
    public void onShareStart() {
        startActivity(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", getString(R.string.application_url)));
    }
}
