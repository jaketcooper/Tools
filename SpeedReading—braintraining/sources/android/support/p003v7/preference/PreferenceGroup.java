package android.support.p003v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RestrictTo;
import android.support.p000v4.content.res.TypedArrayUtils;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v7.preference.PreferenceGroup */
public abstract class PreferenceGroup extends Preference {
    private boolean mAttachedToHierarchy;
    private final Runnable mClearRecycleCacheRunnable;
    private int mCurrentPreferenceOrder;
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final SimpleArrayMap<String, Long> mIdRecycleCache;
    private boolean mOrderingAsAdded;
    private List<Preference> mPreferenceList;

    /* renamed from: android.support.v7.preference.PreferenceGroup$PreferencePositionCallback */
    public interface PreferencePositionCallback {
        int getPreferenceAdapterPosition(Preference preference);

        int getPreferenceAdapterPosition(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mIdRecycleCache = new SimpleArrayMap<>();
        this.mHandler = new Handler();
        this.mClearRecycleCacheRunnable = new Runnable() {
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.mIdRecycleCache.clear();
                }
            }
        };
        this.mPreferenceList = new ArrayList();
        TypedArray a = context.obtainStyledAttributes(attrs, C0381R.styleable.PreferenceGroup, defStyleAttr, defStyleRes);
        this.mOrderingAsAdded = TypedArrayUtils.getBoolean(a, C0381R.styleable.PreferenceGroup_orderingFromXml, C0381R.styleable.PreferenceGroup_orderingFromXml, true);
        a.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setOrderingAsAdded(boolean orderingAsAdded) {
        this.mOrderingAsAdded = orderingAsAdded;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public int getPreferenceCount() {
        return this.mPreferenceList.size();
    }

    public Preference getPreference(int index) {
        return this.mPreferenceList.get(index);
    }

    public boolean addPreference(Preference preference) {
        long id;
        if (this.mPreferenceList.contains(preference)) {
            return true;
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.mOrderingAsAdded) {
                int i = this.mCurrentPreferenceOrder;
                this.mCurrentPreferenceOrder = i + 1;
                preference.setOrder(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.mOrderingAsAdded);
            }
        }
        int insertionIndex = Collections.binarySearch(this.mPreferenceList, preference);
        if (insertionIndex < 0) {
            insertionIndex = (insertionIndex * -1) - 1;
        }
        if (!onPrepareAddPreference(preference)) {
            return false;
        }
        synchronized (this) {
            this.mPreferenceList.add(insertionIndex, preference);
        }
        PreferenceManager preferenceManager = getPreferenceManager();
        String key = preference.getKey();
        if (key == null || !this.mIdRecycleCache.containsKey(key)) {
            id = preferenceManager.getNextId();
        } else {
            id = this.mIdRecycleCache.get(key).longValue();
            this.mIdRecycleCache.remove(key);
        }
        preference.onAttachedToHierarchy(preferenceManager, id);
        preference.assignParent(this);
        if (this.mAttachedToHierarchy) {
            preference.onAttached();
        }
        notifyHierarchyChanged();
        return true;
    }

    public boolean removePreference(Preference preference) {
        boolean returnValue = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return returnValue;
    }

    private boolean removePreferenceInt(Preference preference) {
        boolean success;
        synchronized (this) {
            preference.onPrepareForRemoval();
            if (preference.getParent() == this) {
                preference.assignParent((PreferenceGroup) null);
            }
            success = this.mPreferenceList.remove(preference);
            if (success) {
                String key = preference.getKey();
                if (key != null) {
                    this.mIdRecycleCache.put(key, Long.valueOf(preference.getId()));
                    this.mHandler.removeCallbacks(this.mClearRecycleCacheRunnable);
                    this.mHandler.post(this.mClearRecycleCacheRunnable);
                }
                if (this.mAttachedToHierarchy) {
                    preference.onDetached();
                }
            }
        }
        return success;
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> preferenceList = this.mPreferenceList;
            for (int i = preferenceList.size() - 1; i >= 0; i--) {
                removePreferenceInt(preferenceList.get(0));
            }
        }
        notifyHierarchyChanged();
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareAddPreference(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    public Preference findPreference(CharSequence key) {
        Preference returnedPreference;
        if (TextUtils.equals(getKey(), key)) {
            return this;
        }
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = getPreference(i);
            String curKey = preference.getKey();
            if (curKey != null && curKey.equals(key)) {
                return preference;
            }
            if ((preference instanceof PreferenceGroup) && (returnedPreference = ((PreferenceGroup) preference).findPreference(key)) != null) {
                return returnedPreference;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isOnSameScreenAsChildren() {
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isAttached() {
        return this.mAttachedToHierarchy;
    }

    public void onAttached() {
        super.onAttached();
        this.mAttachedToHierarchy = true;
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onAttached();
        }
    }

    public void onDetached() {
        super.onDetached();
        this.mAttachedToHierarchy = false;
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onDetached();
        }
    }

    public void notifyDependencyChange(boolean disableDependents) {
        super.notifyDependencyChange(disableDependents);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onParentChanged(this, disableDependents);
        }
    }

    /* access modifiers changed from: package-private */
    public void sortPreferences() {
        synchronized (this) {
            Collections.sort(this.mPreferenceList);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(Bundle container) {
        super.dispatchSaveInstanceState(container);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchSaveInstanceState(container);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(Bundle container) {
        super.dispatchRestoreInstanceState(container);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchRestoreInstanceState(container);
        }
    }
}
