package com.jason.basis.classloader;

import com.jason.basis.classloader.ExtensionClassLoader;
import org.junit.Before;
import org.junit.Test;

public class ExtensionClassLoaderTest {

    private ExtensionClassLoader extensionClassLoader;

    @Before
    public void init() {
        extensionClassLoader = new ExtensionClassLoader();
    }

    @Test
    public void getClassPath() {
        String classPath = extensionClassLoader.getClassPath();
        System.out.println(classPath);
    }

}
