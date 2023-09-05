package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.Map;
import java.util.UUID;

public final class PresenterManager {
    public static boolean DEBUG = false;
    public static final String DEBUG_TAG = "PresenterManager";
    static final String KEY_ACTIVITY_ID = "com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId";
    /* access modifiers changed from: private */
    public static final Map<Activity, String> activityIdMap = new ArrayMap();
    static final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            String activityId;
            if (savedInstanceState != null && (activityId = savedInstanceState.getString(PresenterManager.KEY_ACTIVITY_ID)) != null) {
                PresenterManager.activityIdMap.put(activity, activityId);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            String activityId = (String) PresenterManager.activityIdMap.get(activity);
            if (activityId != null) {
                outState.putString(PresenterManager.KEY_ACTIVITY_ID, activityId);
            }
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivityDestroyed(Activity activity) {
            String activityId;
            if (!activity.isChangingConfigurations() && (activityId = (String) PresenterManager.activityIdMap.get(activity)) != null) {
                ActivityScopedCache scopedCache = (ActivityScopedCache) PresenterManager.activityScopedCacheMap.get(activityId);
                if (scopedCache != null) {
                    scopedCache.clear();
                    PresenterManager.activityScopedCacheMap.remove(activityId);
                }
                if (PresenterManager.activityScopedCacheMap.isEmpty()) {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(PresenterManager.activityLifecycleCallbacks);
                    if (PresenterManager.DEBUG) {
                        Log.d(PresenterManager.DEBUG_TAG, "Unregistering ActivityLifecycleCallbacks");
                    }
                }
            }
            PresenterManager.activityIdMap.remove(activity);
        }
    };
    /* access modifiers changed from: private */
    public static final Map<String, ActivityScopedCache> activityScopedCacheMap = new ArrayMap();

    private PresenterManager() {
        throw new RuntimeException("Not instantiatable!");
    }

    @MainThread
    @NonNull
    static ActivityScopedCache getOrCreateActivityScopedCache(@NonNull Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }
        String activityId = activityIdMap.get(activity);
        if (activityId == null) {
            activityId = UUID.randomUUID().toString();
            activityIdMap.put(activity, activityId);
            if (activityIdMap.size() == 1) {
                activity.getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Registering ActivityLifecycleCallbacks");
                }
            }
        }
        ActivityScopedCache activityScopedCache = activityScopedCacheMap.get(activityId);
        if (activityScopedCache != null) {
            return activityScopedCache;
        }
        ActivityScopedCache activityScopedCache2 = new ActivityScopedCache();
        activityScopedCacheMap.put(activityId, activityScopedCache2);
        return activityScopedCache2;
    }

    @Nullable
    @MainThread
    static ActivityScopedCache getActivityScope(@NonNull Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }
        String activityId = activityIdMap.get(activity);
        if (activityId == null) {
            return null;
        }
        return activityScopedCacheMap.get(activityId);
    }

    @Nullable
    public static <P> P getPresenter(@NonNull Activity activity, @NonNull String viewId) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        } else if (viewId == null) {
            throw new NullPointerException("View id is null");
        } else {
            ActivityScopedCache scopedCache = getActivityScope(activity);
            if (scopedCache == null) {
                return null;
            }
            return scopedCache.getPresenter(viewId);
        }
    }

    @Nullable
    public static <VS> VS getViewState(@NonNull Activity activity, @NonNull String viewId) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        } else if (viewId == null) {
            throw new NullPointerException("View id is null");
        } else {
            ActivityScopedCache scopedCache = getActivityScope(activity);
            if (scopedCache == null) {
                return null;
            }
            return scopedCache.getViewState(viewId);
        }
    }

    @NonNull
    public static Activity getActivity(@NonNull Context context) {
        if (context == null) {
            throw new NullPointerException("context == null");
        } else if (context instanceof Activity) {
            return (Activity) context;
        } else {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            throw new IllegalStateException("Could not find the surrounding Activity");
        }
    }

    static void reset() {
        activityIdMap.clear();
        for (ActivityScopedCache scopedCache : activityScopedCacheMap.values()) {
            scopedCache.clear();
        }
        activityScopedCacheMap.clear();
    }

    public static void putPresenter(@NonNull Activity activity, @NonNull String viewId, @NonNull MvpPresenter<? extends MvpView> presenter) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }
        getOrCreateActivityScopedCache(activity).putPresenter(viewId, presenter);
    }

    public static void putViewState(@NonNull Activity activity, @NonNull String viewId, @NonNull Object viewState) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }
        getOrCreateActivityScopedCache(activity).putViewState(viewId, viewState);
    }

    public static void remove(@NonNull Activity activity, @NonNull String viewId) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }
        ActivityScopedCache activityScope = getActivityScope(activity);
        if (activityScope != null) {
            activityScope.remove(viewId);
        }
    }
}
