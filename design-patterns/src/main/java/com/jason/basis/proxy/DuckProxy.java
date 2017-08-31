package com.jason.basis.proxy;

/**
 * Created by jason on 2017/8/31 0031.
 */
public class DuckProxy implements Behavior {

    private Duck duck;

    public DuckProxy(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void run() {
        System.out.println("Before running: Ga Ga Ga!");
        duck.run();
        System.out.println("After running: Ga Ga Ga!");
    }
}
