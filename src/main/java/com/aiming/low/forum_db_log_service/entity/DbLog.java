package com.aiming.low.forum_db_log_service.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

import java.util.Date;


@Value.Immutable
@JsonSerialize(as = ImmutableDbLog.class)
@JsonDeserialize(as = ImmutableDbLog.class)
public interface DbLog {
    @Nullable Long logId();
    @Nullable String optName();
    @Nullable Long userId();
    @Nullable String requestUri();
    @Nullable String method();
    @Nullable String params();
    @Nullable String ip();
    @Nullable String userAgent();
    @Nullable String errorMsg();
    @Nullable Date createTime();
    @Nullable Short executeTime();
    @Nullable LogStatus logStatus();

    enum LogStatus {
        SUCCESS(1),
//        UNDONE(0),
        FAILURE(-1);

        int value;

        LogStatus(int value) {
            this.value = value;
        }

        public static LogStatus fromValue(int value) {
            for (LogStatus ls: LogStatus.values()) {
                if (ls.value == value) {
                    return ls;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }
    }
}