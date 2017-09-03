package com.jason.basis.classloader;

import com.jason.basis.classloader.MyClassLoader;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    private MyClassLoader classLoader;

    @Before
    public void init() {
        classLoader = new MyClassLoader("/Users/jason/Documents/javasoft/items/TestClass");
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
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
