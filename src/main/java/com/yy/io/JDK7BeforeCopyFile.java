package com.yy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @description: jdk1.7之前关闭资源
 * @author: yy
 * @date: 2020/12/24
 */
public class JDK7BeforeCopyFile {


    /**
     * @param source
     * @param target
     */
    public static void copyFile(String source,String target){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            int n = 0;
            byte[] conetnt = new byte[1024];
            while (n != -1) {
                n = fileInputStream.read(conetnt);
                fileOutputStream.write(conetnt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
