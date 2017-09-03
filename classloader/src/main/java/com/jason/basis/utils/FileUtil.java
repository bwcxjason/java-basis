package com.jason.basis.utils;

import java.io.*;

public class FileUtil {

    public static void encrypt(String path) {
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(path + "en");

            int b = 0;
            try {
                while ((b = fis.read()) != -1) {
                    fos.write(b ^ 2);
                }
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
