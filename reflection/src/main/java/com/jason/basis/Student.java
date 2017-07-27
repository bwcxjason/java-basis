package com.jason.basis;

/**
 * Created by jason on 2017/7/27 0027.
 */
public class Student extends People implements Behavior {

    private Student(int age, String name) {
        super(age, name);
    }

    @Override
    public void run() {
        System.out.println("Run run run!");
    }
}
