package org.example.service;

public class PathUtility {
    public static String createRedirectUrl(String currentURL, String redirectPath) {
        int lastIndex = currentURL.lastIndexOf("/");
        return currentURL.substring(0, lastIndex) + redirectPath;
    }
}
