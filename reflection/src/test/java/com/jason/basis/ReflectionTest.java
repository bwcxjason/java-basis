package com.jason.basis;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

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

    @Test
    public void getSuperClazz() {
        try {
            Class<?> clazz = reflection.getSuperClazz();
            System.out.println("Super class name: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInterfaces() {
        try {
            Class<?>[] interfaces = reflection.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                System.out.println(interfaces[i].getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConstructor() {
        try {
            Constructor<?> constructor = reflection.getConstructor();
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.println(parameters[i].getName());
                System.out.println(parameters[i].getParameterizedType());
                System.out.println(parameters[i].getType());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConstructors() {
        try {
            Constructor<?>[] constructors = reflection.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                Constructor<?> constructor = constructors[i];
                Parameter[] parameters = constructor.getParameters();
                for (int j = 0; j < parameters.length; j++) {
                    System.out.println(parameters[j].getName());
                    System.out.println(parameters[j].getParameterizedType());
                    System.out.println(parameters[j].getType());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProperties() {
        try {
            Field[] fields = reflection.getProperties();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                int mod = field.getModifiers();
                System.out.println(Modifier.toString(mod) + " " + field.getType() + " " + field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMethods() {
        try {
            Method[] methods = reflection.getMethods();
            for (int i = 0; i < methods.length; i++) {
                int mod = methods[i].getModifiers();
                Class<?> returnType = methods[i].getReturnType();
                System.out.print(Modifier.toString(mod) + " " + returnType + " " + methods[i].getName());
                Parameter[] parameters = methods[i].getParameters();
                for (int j = 0; j < parameters.length; j++) {
                    System.out.print("(" +parameters[j].getType() + " " + parameters[j].getName());
                }
                System.out.println(")");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
