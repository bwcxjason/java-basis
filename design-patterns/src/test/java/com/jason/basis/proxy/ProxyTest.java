package com.jason.basis.proxy;

import org.junit.Test;

/**
 * Created by jason on 2017/8/31 0031.
 */
public class ProxyTest {

    @Test
    public void duckProxy() {
        Behavior behavior = new DuckProxy(new Duck());
        behavior.run();
    }

}
