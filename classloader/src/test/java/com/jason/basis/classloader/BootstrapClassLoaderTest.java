package com.jason.basis.classloader;

import com.jason.basis.classloader.BootstrapClassLoader;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

public class BootstrapClassLoaderTest {

    private BootstrapClassLoader bootstrapClassLoader;

    @Before
    public void init() {
        bootstrapClassLoader = new BootstrapClassLoader();
    }

    @Test
    public void getClassPath() {
        URL[] urls = bootstrapClassLoader.getClassPath();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }

    @Test
    public void getClassPath0() {
        String classPath = bootstrapClassLoader.getClassPath0();
        System.out.println(classPath);
    }

}
