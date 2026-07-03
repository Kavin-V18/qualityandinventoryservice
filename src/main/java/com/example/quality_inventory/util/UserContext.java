package com.example.quality_inventory.util;

public class UserContext {
    private UserContext() {
    }
    private static final ThreadLocal<Long> USER =
            new ThreadLocal<>();
    public static void setUserId(Long id) {
        USER.set(id);
    }
    public static Long getUserId() {
        return USER.get();
    }
    public static void clear() {
        USER.remove();
    }
}
