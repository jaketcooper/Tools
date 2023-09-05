package com.google.android.gms.internal;

import android.support.p003v7.widget.helper.ItemTouchHelper;

public final class zzcfz {
    private static zzcga<Boolean> zzixk = zzcga.zzb("measurement.service_enabled", true, true);
    private static zzcga<Boolean> zzixl = zzcga.zzb("measurement.service_client_enabled", true, true);
    private static zzcga<Boolean> zzixm = zzcga.zzb("measurement.log_third_party_store_events_enabled", false, false);
    private static zzcga<Boolean> zzixn = zzcga.zzb("measurement.log_installs_enabled", false, false);
    private static zzcga<Boolean> zzixo = zzcga.zzb("measurement.log_upgrades_enabled", false, false);
    private static zzcga<Boolean> zzixp = zzcga.zzb("measurement.log_androidId_enabled", false, false);
    public static zzcga<Boolean> zzixq = zzcga.zzb("measurement.upload_dsid_enabled", false, false);
    public static zzcga<Boolean> zzixr = zzcga.zzb("measurement.event_sampling_enabled", false, false);
    public static zzcga<String> zzixs = zzcga.zzi("measurement.log_tag", "FA", "FA-SVC");
    public static zzcga<Long> zzixt = zzcga.zzb("measurement.ad_id_cache_time", 10000, 10000);
    public static zzcga<Long> zzixu = zzcga.zzb("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static zzcga<Long> zzixv = zzcga.zzb("measurement.config.cache_time", 86400000, 3600000);
    public static zzcga<String> zzixw = zzcga.zzi("measurement.config.url_scheme", "https", "https");
    public static zzcga<String> zzixx = zzcga.zzi("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
    public static zzcga<Integer> zzixy = zzcga.zzm("measurement.upload.max_bundles", 100, 100);
    public static zzcga<Integer> zzixz = zzcga.zzm("measurement.upload.max_batch_size", 65536, 65536);
    public static zzcga<Integer> zziya = zzcga.zzm("measurement.upload.max_bundle_size", 65536, 65536);
    public static zzcga<Integer> zziyb = zzcga.zzm("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static zzcga<Integer> zziyc = zzcga.zzm("measurement.upload.max_events_per_day", 100000, 100000);
    public static zzcga<Integer> zziyd = zzcga.zzm("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static zzcga<Integer> zziye = zzcga.zzm("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static zzcga<Integer> zziyf = zzcga.zzm("measurement.upload.max_conversions_per_day", 500, 500);
    public static zzcga<Integer> zziyg = zzcga.zzm("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static zzcga<Integer> zziyh = zzcga.zzm("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static zzcga<String> zziyi = zzcga.zzi("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
    public static zzcga<Long> zziyj = zzcga.zzb("measurement.upload.backoff_period", 43200000, 43200000);
    public static zzcga<Long> zziyk = zzcga.zzb("measurement.upload.window_interval", 3600000, 3600000);
    public static zzcga<Long> zziyl = zzcga.zzb("measurement.upload.interval", 3600000, 3600000);
    public static zzcga<Long> zziym = zzcga.zzb("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static zzcga<Long> zziyn = zzcga.zzb("measurement.upload.debug_upload_interval", 1000, 1000);
    public static zzcga<Long> zziyo = zzcga.zzb("measurement.upload.minimum_delay", 500, 500);
    public static zzcga<Long> zziyp = zzcga.zzb("measurement.alarm_manager.minimum_interval", 60000, 60000);
    public static zzcga<Long> zziyq = zzcga.zzb("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    public static zzcga<Long> zziyr = zzcga.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static zzcga<Long> zziys = zzcga.zzb("measurement.upload.initial_upload_delay_time", 15000, 15000);
    public static zzcga<Long> zziyt = zzcga.zzb("measurement.upload.retry_time", 1800000, 1800000);
    public static zzcga<Integer> zziyu = zzcga.zzm("measurement.upload.retry_count", 6, 6);
    public static zzcga<Long> zziyv = zzcga.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static zzcga<Integer> zziyw = zzcga.zzm("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static zzcga<Integer> zziyx = zzcga.zzm("measurement.audience.filter_result_max_count", ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    public static zzcga<Long> zziyy = zzcga.zzb("measurement.service_client.idle_disconnect_millis", 5000, 5000);
}
