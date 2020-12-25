package com.yy.stream.guaua;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @description: guaua的IO文件流操作
 * @author: yy
 * @date: 2020/12/25
 */
public class IOExample {

    @Test
    public void testIO() throws IOException {
        String source = "", target = "";
        CharSource charSource = Files.asCharSource(new File(source), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File(target), Charsets.UTF_8);
        // 拷贝文件
        charSource.copyTo(charSink);
        // 简化
        Files.copy(new File(""),new File(""));
    }
}
