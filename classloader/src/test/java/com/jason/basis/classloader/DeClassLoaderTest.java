package com.jason.basis.classloader;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeClassLoaderTest {

    private DeClassLoader classLoader;

    @Before
    public void init() {
        String path = "/Users/jason/Documents/javasoft/items/TestClass";
        classLoader = new DeClassLoader(path);
    }

    @Test
    public void loadClass() {
        try {
            Class c = classLoader.loadClass("Test");

            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say");
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
