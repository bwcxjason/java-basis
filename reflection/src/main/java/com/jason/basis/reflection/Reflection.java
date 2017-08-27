package com.jason.basis.reflection;

import com.jason.basis.model.Behavior;
import com.jason.basis.model.People;
import com.jason.basis.model.Student;

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
        return Class.forName("com.jason.basis.model.People");
    }

    public Class<?> getSuperClazz() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.model.Student");
        return clazz.getSuperclass();
    }

    public Class<?>[] getInterfaces() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.model.Student");
        return clazz.getInterfaces();
    }

    public Constructor<?> getConstructor() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.model.People");
        return clazz.getConstructor();
    }

    public Constructor<?>[] getConstructors() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.model.People");
        return clazz.getConstructors();
    }

    public Field[] getProperties() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.model.People");
        return clazz.getDeclaredFields();
    }

    public Method[] getMethods() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.jason.basis.model.People");
        return clazz.getMethods();
    }

    public void invokeMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.jason.basis.model.People");
        Method method = clazz.getMethod("eat");
        method.invoke(clazz.newInstance());

        method = clazz.getMethod("eat", String.class);
        method.invoke(clazz.newInstance(), "food");
    }

    public void operateProperty() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.jason.basis.model.People");
        Object obj = clazz.newInstance();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj, "jason");
        System.out.printf(String.valueOf(field.get(obj)));
    }

    public void dynamicProxy() {
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        Student student = new Student();
        Behavior behavior = (Student) invocationHandler.bind(student);
        behavior.run();
    }

}
