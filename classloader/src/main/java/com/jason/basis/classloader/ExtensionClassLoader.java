package com.jason.basis.classloader;

public class ExtensionClassLoader {

    public String getClassPath() {
        return System.getProperty("java.ext.dirs");
    }

}
