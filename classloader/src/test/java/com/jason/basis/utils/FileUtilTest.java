package com.jason.basis.utils;

import org.junit.Test;

public class FileUtilTest {

    @Test
    public void encrypt() {
        String path = "/Users/jason/Documents/javasoft/items/TestClass/Test.class";
        FileUtil.encrypt(path);
    }

}
