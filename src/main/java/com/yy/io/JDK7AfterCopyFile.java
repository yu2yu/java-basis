package com.yy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @description: jdk1.7之后关闭资源
 * @author: yy
 * @date: 2020/12/24
 */
public class JDK7AfterCopyFile {


    /**
     * @param source
     * @param target
     */
    public static void copyFile(String source,String target){
        try (
                FileInputStream fileInputStream = new FileInputStream(source);
                FileOutputStream fileOutputStream = new FileOutputStream(target);
        ){
            int n = 0;
            while ((n = fileInputStream.read()) != -1) {
                fileOutputStream.write(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        copyFile("E:\\project\\java-basis\\src\\main\\java\\com\\yy\\io\\a.txt",
                "E:\\project\\java-basis\\src\\main\\java\\com\\yy\\io\\b.txt");
    }

}
