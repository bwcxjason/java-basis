package com.jason.basis.classloader;

import com.jason.basis.classloader.AppClassLoader;
import org.junit.Before;
import org.junit.Test;

public class AppClassLoaderTest {

    private AppClassLoader appClassLoader;

    @Before
    public void init() {
        appClassLoader = new AppClassLoader();
    }

    @Test
    public void getClassPath() {
        String classPath = appClassLoader.getClassPath();
        System.out.println(classPath);
    }

}
