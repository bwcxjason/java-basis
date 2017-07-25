package com.jason.basis;

/**
 * Created by jason on 2017/7/25 0025.
 */
public class People {

    public static final String complexion = "yellow";

    protected double money;
    protected float gold;

    private int age;
    private String name;

    private People() {

    }

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void eat(String food) {
        System.out.println("I am eating " + food);
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public float getGold() {
        return gold;
    }

    public void setGold(float gold) {
        this.gold = gold;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "money=" + money +
                ", gold=" + gold +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
