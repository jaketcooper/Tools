package com.safonov.speedreading.main.activity.view;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class MenuActivity_ViewBinding implements Unbinder {
    private MenuActivity target;
    private View view2131296268;

    @UiThread
    public MenuActivity_ViewBinding(MenuActivity target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public MenuActivity_ViewBinding(final MenuActivity target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target2.navigation = (BottomNavigationView) Utils.findRequiredViewAsType(source, R.id.bottom_navigation, "field 'navigation'", BottomNavigationView.class);
        View view = Utils.findRequiredView(source, R.id.action_bar_premium_icon, "field 'purchasePremiumView' and method 'onPremiumClick'");
        target2.purchasePremiumView = view;
        this.view2131296268 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumClick();
            }
        });
        Resources res = source.getContext().getResources();
        target2.notifyKey = res.getString(R.string.notifications_settings_notify_key);
        target2.notifyTimeKey = res.getString(R.string.notifications_settings_notify_time_key);
    }

    @CallSuper
    public void unbind() {
        MenuActivity target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
        target2.navigation = null;
        target2.purchasePremiumView = null;
        this.view2131296268.setOnClickListener((View.OnClickListener) null);
        this.view2131296268 = null;
    }
}
