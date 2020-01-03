package com.midea.logistics.lpc.atomic.gen.util;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class PathUtil {

    public static String getJarPath(String classPath) {

        Class clazz = null;
        try {
            clazz = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return getJarPath(clazz);

    }

    public static String getJarPath(Class clazz) {

        String filePath = null;
        try {
            java.net.URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
            filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return filePath;
    }


    public static String getDistPath() {
        String property = System.getProperty("catalina.base");
        String dateStr = DateUtil.getYyyyMmDdHhMmSsSss(System.currentTimeMillis())
            .replace("-", "")
            .replace(":", "")
            .replace(".", "")
            .replace(" ", "");
        String genPath = property + "/gen/" + dateStr;
        File fileDir = new File(genPath);
        if (!fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        return genPath;
    }


}
