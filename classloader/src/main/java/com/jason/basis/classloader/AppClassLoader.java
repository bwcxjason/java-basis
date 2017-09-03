package com.jason.basis.classloader;

public class AppClassLoader {

    public String getClassPath() {
        return System.getProperty("java.class.path");
    }

}
