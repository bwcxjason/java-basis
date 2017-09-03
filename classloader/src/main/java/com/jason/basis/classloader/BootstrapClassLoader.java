package com.jason.basis.classloader;

import sun.misc.Launcher;

import java.net.URL;

public class BootstrapClassLoader {

    public URL[] getClassPath() {
        return Launcher.getBootstrapClassPath().getURLs();
    }

    public String getClassPath0() {
        return System.getProperty("sun.boot.class.path");
    }

}
