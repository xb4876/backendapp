package com.renwu.backendapp.core.utils;

public class GlobleParms {
    private static String serverBasePath = null;

    public static void setServerBasePath(String serverBasePath) {
        GlobleParms.serverBasePath = serverBasePath;
    }

    public static String getServerBasePath() {
        return GlobleParms.serverBasePath;
    }
}
