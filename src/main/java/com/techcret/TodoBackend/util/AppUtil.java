package com.techcret.TodoBackend.util;

import java.util.UUID;

public class AppUtil {

    public static String generateRandomUniqueString() {
        return UUID.randomUUID().toString();
    }

}
