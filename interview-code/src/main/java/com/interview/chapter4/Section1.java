package com.interview.chapter4;

import java.io.*;

public class Section1 {
    public static void main(String[] args) throws IOException {
        // 给指定目录下的文件追加信息
        Writer writer = new FileWriter("d:\\io.txt",false);
        writer.append("老王");
        writer.close();

        Reader reader = new FileReader("d:\\io.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;
        while (null != (str = bufferedReader.readLine())) {
            System.out.println(str);
        }


    }

}
