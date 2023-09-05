package com.safonov.speedreading.application.realm;

public interface UnixTimeRealmObject {
    public static final String FIELD_UNIX_TIME = "unixTime";

    long getUnixTime();

    void setUnixTime(long j);
}
