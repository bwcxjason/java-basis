package com.jason.basis.classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DeClassLoader extends ClassLoader {

    private String classPath;

    public DeClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(classPath, fileName);

        try {
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int len = 0;
            byte b = 0;
            try {
                while ((len = is.read()) != -1) {
                    b = (byte) (len ^ 2);
                    bos.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = bos.toByteArray();
            is.close();
            bos.close();

            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".classen";
        } else {
            return name.substring(index + 1) + ".classen";
        }
    }
}
