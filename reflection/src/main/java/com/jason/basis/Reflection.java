package com.jason.basis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jason on 2017/7/25 0025.
 */
public class Reflection {

    public String getClazzNameByInstance() {
        People people = new People(12, "jason");
        return people.getClass().getName();
    }

    public Class<?> getInstance() throws ClassNotFoundException {
        return Class.forName("com.jason.basis.People");
    }

    public Class<?> getSuperClazz() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.Student");
        return clazz.getSuperclass();
    }

    public Class<?>[] getInterfaces() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.Student");
        return clazz.getInterfaces();
    }

    public Constructor<?> getConstructor() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.People");
        return clazz.getConstructor();
    }

    public Constructor<?>[] getConstructors() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.People");
        return clazz.getConstructors();
    }

    public Field[] getProperties() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.People");
        return clazz.getDeclaredFields();
    }

    public Method[] getMethods() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.People");
        return clazz.getMethods();
    }

    public void invokeMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.jason.basis.People");
        Method method = clazz.getMethod("eat");
        method.invoke(clazz.newInstance());
    }

}
