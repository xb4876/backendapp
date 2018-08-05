package com.renwu.backendapp.core.utils;

public class GlobleParms {

    public static String androidAppPath = "http://ren-wu.cn/assets/apk/RenWuWallet_0.1.apk";

    private static String serverBasePath = null;

    public static void setServerBasePath(String serverBasePath) {
        GlobleParms.serverBasePath = serverBasePath;
    }

    public static String getServerBasePath() {
        return GlobleParms.serverBasePath;
    }
}
