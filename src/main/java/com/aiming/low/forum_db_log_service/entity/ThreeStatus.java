package com.aiming.low.forum_db_log_service.entity;

public enum ThreeStatus {

    ACTIVE(1),
    NOT_ACTIVE(0),
    DELETE(-1);

    int value;

    ThreeStatus(int value) {
        this.value = value;
    }

    public static ThreeStatus fromValue(int value) {
        for (ThreeStatus ts: ThreeStatus.values()) {
            if (ts.value == value) {
                return ts;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
