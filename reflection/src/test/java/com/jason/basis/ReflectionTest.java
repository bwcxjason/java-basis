package com.jason.basis;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jason on 2017/7/25 0025.
 */
public class ReflectionTest {

    private Reflection reflection;

    @Before
    public void init() {
        reflection = new Reflection();
    }

    @Test
    public void getClazzNameByInstance() {
        String clazzName = reflection.getClazzNameByInstance();
        System.out.println(clazzName);
    }

    @Test
    public void getInstance() {
        try {
            Class<?> clazz = reflection.getInstance();
            System.out.println(clazz.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
