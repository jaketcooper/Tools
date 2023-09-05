package com.safonov.speedreading.main.fragment.profile.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class ProfileFragment_ViewBinding implements Unbinder {
    private ProfileFragment target;
    private View view2131296583;
    private View view2131296587;
    private View view2131296588;

    @UiThread
    public ProfileFragment_ViewBinding(final ProfileFragment target2, View source) {
        this.target = target2;
        target2.profileTypeTV = (TextView) Utils.findRequiredViewAsType(source, R.id.profile_type_tv, "field 'profileTypeTV'", TextView.class);
        target2.profileRatingTv = (TextView) Utils.findRequiredViewAsType(source, R.id.profile_rating_tv, "field 'profileRatingTv'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.privacy_policy_button, "method 'onPrivacyPolicyClick'");
        this.view2131296583 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPrivacyPolicyClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.profile_settings_view, "method 'onSettingsStart'");
        this.view2131296587 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSettingsStart();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.profile_share_view, "method 'onShareStart'");
        this.view2131296588 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onShareStart();
            }
        });
    }

    @CallSuper
    public void unbind() {
        ProfileFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.profileTypeTV = null;
        target2.profileRatingTv = null;
        this.view2131296583.setOnClickListener((View.OnClickListener) null);
        this.view2131296583 = null;
        this.view2131296587.setOnClickListener((View.OnClickListener) null);
        this.view2131296587 = null;
        this.view2131296588.setOnClickListener((View.OnClickListener) null);
        this.view2131296588 = null;
    }
}
