package com.jason.basis.reference;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jason on 2017/8/10 0010.
 */
public class StrongReferenceTest {

    private StrongReference strongReference;

    @Before
    public void init() {
        strongReference = new StrongReference();
    }

    @Test
    public void createStrongRef() {
        System.out.println(strongReference.createStrongRef());
    }

    @Test
    public void destroyStrongRef() {
        strongReference.destroyStrongRef();
    }

}
