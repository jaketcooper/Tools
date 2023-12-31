package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.preference.CheckBoxPreference */
public class CheckBoxPreference extends TwoStatePreference {
    private final Listener mListener;

    /* renamed from: android.support.v7.preference.CheckBoxPreference$Listener */
    private class Listener implements CompoundButton.OnCheckedChangeListener {
        private Listener() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!CheckBoxPreference.this.callChangeListener(Boolean.valueOf(isChecked))) {
                buttonView.setChecked(!isChecked);
            } else {
                CheckBoxPreference.this.setChecked(isChecked);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mListener = new Listener();
        TypedArray a = context.obtainStyledAttributes(attrs, C0381R.styleable.CheckBoxPreference, defStyleAttr, defStyleRes);
        setSummaryOn((CharSequence) TypedArrayUtils.getString(a, C0381R.styleable.CheckBoxPreference_summaryOn, C0381R.styleable.CheckBoxPreference_android_summaryOn));
        setSummaryOff((CharSequence) TypedArrayUtils.getString(a, C0381R.styleable.CheckBoxPreference_summaryOff, C0381R.styleable.CheckBoxPreference_android_summaryOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(a, C0381R.styleable.CheckBoxPreference_disableDependentsState, C0381R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        a.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attrs) {
        this(context, attrs, TypedArrayUtils.getAttr(context, C0381R.attr.checkBoxPreferenceStyle, 16842895));
    }

    public CheckBoxPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        syncCheckboxView(holder.findViewById(16908289));
        syncSummaryView(holder);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick(View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            syncCheckboxView(view.findViewById(16908289));
            syncSummaryView(view.findViewById(16908304));
        }
    }

    private void syncCheckboxView(View view) {
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.mListener);
        }
    }
}
