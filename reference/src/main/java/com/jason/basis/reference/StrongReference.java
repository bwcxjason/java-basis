package com.jason.basis.reference;

/**
 * Created by jason on 2017/8/8 0008.
 */
public class StrongReference {

    private Object strongRef;

    public Object createStrongRef() {
        strongRef = new Object();
        return strongRef;
    }

    public void destroyStrongRef() {
        strongRef = null;
    }

}
