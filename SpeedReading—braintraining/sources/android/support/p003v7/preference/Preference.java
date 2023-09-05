package android.support.p003v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.content.SharedPreferencesCompat;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p003v7.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: android.support.v7.preference.Preference */
public class Preference implements Comparable<Preference> {
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private Context mContext;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;
    @Nullable
    private PreferenceDataStore mPreferenceDataStore;
    @Nullable
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    /* renamed from: android.support.v7.preference.Preference$OnPreferenceChangeInternalListener */
    interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);

        void onPreferenceVisibilityChange(Preference preference);
    }

    /* renamed from: android.support.v7.preference.Preference$OnPreferenceChangeListener */
    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    /* renamed from: android.support.v7.preference.Preference$OnPreferenceClickListener */
    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    public Preference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = C0381R.C0384layout.preference;
        this.mClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                Preference.this.performClick(v);
            }
        };
        this.mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, C0381R.styleable.Preference, defStyleAttr, defStyleRes);
        this.mIconResId = TypedArrayUtils.getResourceId(a, C0381R.styleable.Preference_icon, C0381R.styleable.Preference_android_icon, 0);
        this.mKey = TypedArrayUtils.getString(a, C0381R.styleable.Preference_key, C0381R.styleable.Preference_android_key);
        this.mTitle = TypedArrayUtils.getText(a, C0381R.styleable.Preference_title, C0381R.styleable.Preference_android_title);
        this.mSummary = TypedArrayUtils.getText(a, C0381R.styleable.Preference_summary, C0381R.styleable.Preference_android_summary);
        this.mOrder = TypedArrayUtils.getInt(a, C0381R.styleable.Preference_order, C0381R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.mFragment = TypedArrayUtils.getString(a, C0381R.styleable.Preference_fragment, C0381R.styleable.Preference_android_fragment);
        this.mLayoutResId = TypedArrayUtils.getResourceId(a, C0381R.styleable.Preference_layout, C0381R.styleable.Preference_android_layout, C0381R.C0384layout.preference);
        this.mWidgetLayoutResId = TypedArrayUtils.getResourceId(a, C0381R.styleable.Preference_widgetLayout, C0381R.styleable.Preference_android_widgetLayout, 0);
        this.mEnabled = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_enabled, C0381R.styleable.Preference_android_enabled, true);
        this.mSelectable = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_selectable, C0381R.styleable.Preference_android_selectable, true);
        this.mPersistent = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_persistent, C0381R.styleable.Preference_android_persistent, true);
        this.mDependencyKey = TypedArrayUtils.getString(a, C0381R.styleable.Preference_dependency, C0381R.styleable.Preference_android_dependency);
        this.mAllowDividerAbove = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_allowDividerAbove, C0381R.styleable.Preference_allowDividerAbove, this.mSelectable);
        this.mAllowDividerBelow = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_allowDividerBelow, C0381R.styleable.Preference_allowDividerBelow, this.mSelectable);
        if (a.hasValue(C0381R.styleable.Preference_defaultValue)) {
            this.mDefaultValue = onGetDefaultValue(a, C0381R.styleable.Preference_defaultValue);
        } else if (a.hasValue(C0381R.styleable.Preference_android_defaultValue)) {
            this.mDefaultValue = onGetDefaultValue(a, C0381R.styleable.Preference_android_defaultValue);
        }
        this.mShouldDisableView = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_shouldDisableView, C0381R.styleable.Preference_android_shouldDisableView, true);
        this.mHasSingleLineTitleAttr = a.hasValue(C0381R.styleable.Preference_singleLineTitle);
        if (this.mHasSingleLineTitleAttr) {
            this.mSingleLineTitle = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_singleLineTitle, C0381R.styleable.Preference_android_singleLineTitle, true);
        }
        this.mIconSpaceReserved = TypedArrayUtils.getBoolean(a, C0381R.styleable.Preference_iconSpaceReserved, C0381R.styleable.Preference_android_iconSpaceReserved, false);
        a.recycle();
    }

    public Preference(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Preference(Context context, AttributeSet attrs) {
        this(context, attrs, TypedArrayUtils.getAttr(context, C0381R.attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray a, int index) {
        return null;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public void setFragment(String fragment) {
        this.mFragment = fragment;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public void setPreferenceDataStore(PreferenceDataStore dataStore) {
        this.mPreferenceDataStore = dataStore;
    }

    @Nullable
    public PreferenceDataStore getPreferenceDataStore() {
        if (this.mPreferenceDataStore != null) {
            return this.mPreferenceDataStore;
        }
        if (this.mPreferenceManager != null) {
            return this.mPreferenceManager.getPreferenceDataStore();
        }
        return null;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    public void setLayoutResource(int layoutResId) {
        this.mLayoutResId = layoutResId;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public void setWidgetLayoutResource(int widgetLayoutResId) {
        this.mWidgetLayoutResId = widgetLayoutResId;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public void onBindViewHolder(PreferenceViewHolder holder) {
        int i = 4;
        holder.itemView.setOnClickListener(this.mClickListener);
        holder.itemView.setId(this.mViewId);
        TextView titleView = (TextView) holder.findViewById(16908310);
        if (titleView != null) {
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                titleView.setText(title);
                titleView.setVisibility(0);
                if (this.mHasSingleLineTitleAttr) {
                    titleView.setSingleLine(this.mSingleLineTitle);
                }
            } else {
                titleView.setVisibility(8);
            }
        }
        TextView summaryView = (TextView) holder.findViewById(16908304);
        if (summaryView != null) {
            CharSequence summary = getSummary();
            if (!TextUtils.isEmpty(summary)) {
                summaryView.setText(summary);
                summaryView.setVisibility(0);
            } else {
                summaryView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) holder.findViewById(16908294);
        if (imageView != null) {
            if (!(this.mIconResId == 0 && this.mIcon == null)) {
                if (this.mIcon == null) {
                    this.mIcon = ContextCompat.getDrawable(getContext(), this.mIconResId);
                }
                if (this.mIcon != null) {
                    imageView.setImageDrawable(this.mIcon);
                }
            }
            if (this.mIcon != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.mIconSpaceReserved ? 4 : 8);
            }
        }
        View imageFrame = holder.findViewById(C0381R.C0383id.icon_frame);
        if (imageFrame == null) {
            imageFrame = holder.findViewById(AndroidResources.ANDROID_R_ICON_FRAME);
        }
        if (imageFrame != null) {
            if (this.mIcon != null) {
                imageFrame.setVisibility(0);
            } else {
                if (!this.mIconSpaceReserved) {
                    i = 8;
                }
                imageFrame.setVisibility(i);
            }
        }
        if (this.mShouldDisableView) {
            setEnabledStateOnViews(holder.itemView, isEnabled());
        } else {
            setEnabledStateOnViews(holder.itemView, true);
        }
        boolean selectable = isSelectable();
        holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);
        holder.setDividerAllowedAbove(this.mAllowDividerAbove);
        holder.setDividerAllowedBelow(this.mAllowDividerBelow);
    }

    private void setEnabledStateOnViews(View v, boolean enabled) {
        v.setEnabled(enabled);
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                setEnabledStateOnViews(vg.getChildAt(i), enabled);
            }
        }
    }

    public void setOrder(int order) {
        if (order != this.mOrder) {
            this.mOrder = order;
            notifyHierarchyChanged();
        }
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setViewId(int viewId) {
        this.mViewId = viewId;
    }

    public void setTitle(CharSequence title) {
        if ((title == null && this.mTitle != null) || (title != null && !title.equals(this.mTitle))) {
            this.mTitle = title;
            notifyChanged();
        }
    }

    public void setTitle(int titleResId) {
        setTitle((CharSequence) this.mContext.getString(titleResId));
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public void setIcon(Drawable icon) {
        if ((icon == null && this.mIcon != null) || (icon != null && this.mIcon != icon)) {
            this.mIcon = icon;
            this.mIconResId = 0;
            notifyChanged();
        }
    }

    public void setIcon(int iconResId) {
        setIcon(ContextCompat.getDrawable(this.mContext, iconResId));
        this.mIconResId = iconResId;
    }

    public Drawable getIcon() {
        if (this.mIcon == null && this.mIconResId != 0) {
            this.mIcon = ContextCompat.getDrawable(this.mContext, this.mIconResId);
        }
        return this.mIcon;
    }

    public CharSequence getSummary() {
        return this.mSummary;
    }

    public void setSummary(CharSequence summary) {
        if ((summary == null && this.mSummary != null) || (summary != null && !summary.equals(this.mSummary))) {
            this.mSummary = summary;
            notifyChanged();
        }
    }

    public void setSummary(int summaryResId) {
        setSummary((CharSequence) this.mContext.getString(summaryResId));
    }

    public void setEnabled(boolean enabled) {
        if (this.mEnabled != enabled) {
            this.mEnabled = enabled;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet && this.mParentDependencyMet;
    }

    public void setSelectable(boolean selectable) {
        if (this.mSelectable != selectable) {
            this.mSelectable = selectable;
            notifyChanged();
        }
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public void setShouldDisableView(boolean shouldDisableView) {
        this.mShouldDisableView = shouldDisableView;
        notifyChanged();
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public final void setVisible(boolean visible) {
        if (this.mVisible != visible) {
            this.mVisible = visible;
            if (this.mListener != null) {
                this.mListener.onPreferenceVisibilityChange(this);
            }
        }
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    /* access modifiers changed from: package-private */
    public long getId() {
        return this.mId;
    }

    /* access modifiers changed from: protected */
    public void onClick() {
    }

    public void setKey(String key) {
        this.mKey = key;
        if (this.mRequiresKey && !hasKey()) {
            requireKey();
        }
    }

    public String getKey() {
        return this.mKey;
    }

    /* access modifiers changed from: package-private */
    public void requireKey() {
        if (TextUtils.isEmpty(this.mKey)) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        this.mRequiresKey = true;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    /* access modifiers changed from: protected */
    public boolean shouldPersist() {
        return this.mPreferenceManager != null && isPersistent() && hasKey();
    }

    public void setPersistent(boolean persistent) {
        this.mPersistent = persistent;
    }

    public void setSingleLineTitle(boolean singleLineTitle) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = singleLineTitle;
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public void setIconSpaceReserved(boolean iconSpaceReserved) {
        this.mIconSpaceReserved = iconSpaceReserved;
        notifyChanged();
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public boolean callChangeListener(Object newValue) {
        return this.mOnChangeListener == null || this.mOnChangeListener.onPreferenceChange(this, newValue);
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.mOnChangeListener = onPreferenceChangeListener;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.mOnClickListener = onPreferenceClickListener;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick(View view) {
        performClick();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick() {
        PreferenceManager.OnPreferenceTreeClickListener listener;
        if (isEnabled()) {
            onClick();
            if (this.mOnClickListener == null || !this.mOnClickListener.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (listener = preferenceManager.getOnPreferenceTreeClickListener()) == null || !listener.onPreferenceTreeClick(this)) && this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager == null || getPreferenceDataStore() != null) {
            return null;
        }
        return this.mPreferenceManager.getSharedPreferences();
    }

    public int compareTo(@NonNull Preference another) {
        if (this.mOrder != another.mOrder) {
            return this.mOrder - another.mOrder;
        }
        if (this.mTitle == another.mTitle) {
            return 0;
        }
        if (this.mTitle == null) {
            return 1;
        }
        if (another.mTitle == null) {
            return -1;
        }
        return this.mTitle.toString().compareToIgnoreCase(another.mTitle.toString());
    }

    /* access modifiers changed from: package-private */
    public final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener listener) {
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public void notifyChanged() {
        if (this.mListener != null) {
            this.mListener.onPreferenceChange(this);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyHierarchyChanged() {
        if (this.mListener != null) {
            this.mListener.onPreferenceHierarchyChange(this);
        }
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        if (!this.mHasId) {
            this.mId = preferenceManager.getNextId();
        }
        dispatchSetInitialValue();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onAttachedToHierarchy(PreferenceManager preferenceManager, long id) {
        this.mId = id;
        this.mHasId = true;
        try {
            onAttachedToHierarchy(preferenceManager);
        } finally {
            this.mHasId = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void assignParent(@Nullable PreferenceGroup parentGroup) {
        this.mParentGroup = parentGroup;
    }

    public void onAttached() {
        registerDependency();
    }

    public void onDetached() {
        unregisterDependency();
        this.mWasDetached = true;
    }

    public final boolean wasDetached() {
        return this.mWasDetached;
    }

    public final void clearWasDetached() {
        this.mWasDetached = false;
    }

    private void registerDependency() {
        if (!TextUtils.isEmpty(this.mDependencyKey)) {
            Preference preference = findPreferenceInHierarchy(this.mDependencyKey);
            if (preference != null) {
                preference.registerDependent(this);
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + this.mTitle + "\"");
        }
    }

    private void unregisterDependency() {
        Preference oldDependency;
        if (this.mDependencyKey != null && (oldDependency = findPreferenceInHierarchy(this.mDependencyKey)) != null) {
            oldDependency.unregisterDependent(this);
        }
    }

    /* access modifiers changed from: protected */
    public Preference findPreferenceInHierarchy(String key) {
        if (TextUtils.isEmpty(key) || this.mPreferenceManager == null) {
            return null;
        }
        return this.mPreferenceManager.findPreference(key);
    }

    private void registerDependent(Preference dependent) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(dependent);
        dependent.onDependencyChanged(this, shouldDisableDependents());
    }

    private void unregisterDependent(Preference dependent) {
        if (this.mDependents != null) {
            this.mDependents.remove(dependent);
        }
    }

    public void notifyDependencyChange(boolean disableDependents) {
        List<Preference> dependents = this.mDependents;
        if (dependents != null) {
            int dependentsCount = dependents.size();
            for (int i = 0; i < dependentsCount; i++) {
                dependents.get(i).onDependencyChanged(this, disableDependents);
            }
        }
    }

    public void onDependencyChanged(Preference dependency, boolean disableDependent) {
        if (this.mDependencyMet == disableDependent) {
            this.mDependencyMet = !disableDependent;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onParentChanged(Preference parent, boolean disableChild) {
        if (this.mParentDependencyMet == disableChild) {
            this.mParentDependencyMet = !disableChild;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public void setDependency(String dependencyKey) {
        unregisterDependency();
        this.mDependencyKey = dependencyKey;
        registerDependency();
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    @Nullable
    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    /* access modifiers changed from: protected */
    public void onPrepareForRemoval() {
        unregisterDependency();
    }

    public void setDefaultValue(Object defaultValue) {
        this.mDefaultValue = defaultValue;
    }

    private void dispatchSetInitialValue() {
        if (getPreferenceDataStore() != null) {
            onSetInitialValue(true, this.mDefaultValue);
        } else if (shouldPersist() && getSharedPreferences().contains(this.mKey)) {
            onSetInitialValue(true, (Object) null);
        } else if (this.mDefaultValue != null) {
            onSetInitialValue(false, this.mDefaultValue);
        }
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
    }

    private void tryCommit(@NonNull SharedPreferences.Editor editor) {
        if (this.mPreferenceManager.shouldCommit()) {
            SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
        }
    }

    /* access modifiers changed from: protected */
    public boolean persistString(String value) {
        if (!shouldPersist()) {
            return false;
        }
        if (TextUtils.equals(value, getPersistedString((String) null))) {
            return true;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            dataStore.putString(this.mKey, value);
            return true;
        }
        SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
        editor.putString(this.mKey, value);
        tryCommit(editor);
        return true;
    }

    /* access modifiers changed from: protected */
    public String getPersistedString(String defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            return dataStore.getString(this.mKey, defaultReturnValue);
        }
        return this.mPreferenceManager.getSharedPreferences().getString(this.mKey, defaultReturnValue);
    }

    public boolean persistStringSet(Set<String> values) {
        if (!shouldPersist()) {
            return false;
        }
        if (values.equals(getPersistedStringSet((Set<String>) null))) {
            return true;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            dataStore.putStringSet(this.mKey, values);
            return true;
        }
        SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
        editor.putStringSet(this.mKey, values);
        tryCommit(editor);
        return true;
    }

    public Set<String> getPersistedStringSet(Set<String> defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            return dataStore.getStringSet(this.mKey, defaultReturnValue);
        }
        return this.mPreferenceManager.getSharedPreferences().getStringSet(this.mKey, defaultReturnValue);
    }

    /* access modifiers changed from: protected */
    public boolean persistInt(int value) {
        if (!shouldPersist()) {
            return false;
        }
        if (value == getPersistedInt(value ^ -1)) {
            return true;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            dataStore.putInt(this.mKey, value);
            return true;
        }
        SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
        editor.putInt(this.mKey, value);
        tryCommit(editor);
        return true;
    }

    /* access modifiers changed from: protected */
    public int getPersistedInt(int defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            return dataStore.getInt(this.mKey, defaultReturnValue);
        }
        return this.mPreferenceManager.getSharedPreferences().getInt(this.mKey, defaultReturnValue);
    }

    /* access modifiers changed from: protected */
    public boolean persistFloat(float value) {
        if (!shouldPersist()) {
            return false;
        }
        if (value == getPersistedFloat(Float.NaN)) {
            return true;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            dataStore.putFloat(this.mKey, value);
            return true;
        }
        SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
        editor.putFloat(this.mKey, value);
        tryCommit(editor);
        return true;
    }

    /* access modifiers changed from: protected */
    public float getPersistedFloat(float defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            return dataStore.getFloat(this.mKey, defaultReturnValue);
        }
        return this.mPreferenceManager.getSharedPreferences().getFloat(this.mKey, defaultReturnValue);
    }

    /* access modifiers changed from: protected */
    public boolean persistLong(long value) {
        if (!shouldPersist()) {
            return false;
        }
        if (value == getPersistedLong(-1 ^ value)) {
            return true;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            dataStore.putLong(this.mKey, value);
            return true;
        }
        SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
        editor.putLong(this.mKey, value);
        tryCommit(editor);
        return true;
    }

    /* access modifiers changed from: protected */
    public long getPersistedLong(long defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            return dataStore.getLong(this.mKey, defaultReturnValue);
        }
        return this.mPreferenceManager.getSharedPreferences().getLong(this.mKey, defaultReturnValue);
    }

    /* access modifiers changed from: protected */
    public boolean persistBoolean(boolean value) {
        boolean z = false;
        if (!shouldPersist()) {
            return false;
        }
        if (!value) {
            z = true;
        }
        if (value == getPersistedBoolean(z)) {
            return true;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            dataStore.putBoolean(this.mKey, value);
            return true;
        }
        SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
        editor.putBoolean(this.mKey, value);
        tryCommit(editor);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean getPersistedBoolean(boolean defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        PreferenceDataStore dataStore = getPreferenceDataStore();
        if (dataStore != null) {
            return dataStore.getBoolean(this.mKey, defaultReturnValue);
        }
        return this.mPreferenceManager.getSharedPreferences().getBoolean(this.mKey, defaultReturnValue);
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    /* access modifiers changed from: package-private */
    public StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title).append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary).append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void saveHierarchyState(Bundle container) {
        dispatchSaveInstanceState(container);
    }

    /* access modifiers changed from: package-private */
    public void dispatchSaveInstanceState(Bundle container) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable state = onSaveInstanceState();
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (state != null) {
                container.putParcelable(this.mKey, state);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return BaseSavedState.EMPTY_STATE;
    }

    public void restoreHierarchyState(Bundle container) {
        dispatchRestoreInstanceState(container);
    }

    /* access modifiers changed from: package-private */
    public void dispatchRestoreInstanceState(Bundle container) {
        Parcelable state;
        if (hasKey() && (state = container.getParcelable(this.mKey)) != null) {
            this.mBaseMethodCalled = false;
            onRestoreInstanceState(state);
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        this.mBaseMethodCalled = true;
        if (state != BaseSavedState.EMPTY_STATE && state != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    @CallSuper
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat info) {
    }

    /* renamed from: android.support.v7.preference.Preference$BaseSavedState */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }

            public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        };

        public BaseSavedState(Parcel source) {
            super(source);
        }

        public BaseSavedState(Parcelable superState) {
            super(superState);
        }
    }
}
