package com.apollogix.exam.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtil {
    public static Long toTimeStamp(LocalDateTime time) {
        if (time == null) {
            return null;
        }
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
