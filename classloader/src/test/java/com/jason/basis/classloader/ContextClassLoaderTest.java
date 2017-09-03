package com.jason.basis.classloader;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ContextClassLoaderTest {

    private MyClassLoader myClassLoader;
    private MyClassLoader myClassLoader1;
    private Class c;
    private Class c1;

    @Before
    public void init() {
        myClassLoader = new MyClassLoader("/Users/jason/Documents/javasoft/items/TestClass");
        myClassLoader1 = new MyClassLoader("/Users/jason/Documents/javasoft/items/TestClass");
    }

    @Test
    public void loadClass() {
        try {
            c = myClassLoader.loadClass("Test");
            if (c != null) {
                try {
                    System.out.println(c.getClassLoader().toString());
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

        System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());
                try {
                    Thread.currentThread().setContextClassLoader(myClassLoader1);
                    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                    c1 = classLoader.loadClass("Test");
                    Object obj = c1.newInstance();
                    Method method = c1.getDeclaredMethod("say");
                    method.invoke(obj, null);
                    System.out.println(c1.getClassLoader().toString());
                } catch (ClassNotFoundException
                        | InstantiationException
                        | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
            System.out.println(c.getClass().toString());
            System.out.println(c1.getClass().toString());
            System.out.println(c == c1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
