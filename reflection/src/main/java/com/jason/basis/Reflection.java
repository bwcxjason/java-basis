package com.jason.basis;

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

}
