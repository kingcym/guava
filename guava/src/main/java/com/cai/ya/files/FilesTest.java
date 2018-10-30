package com.cai.ya.files;

import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/21 22:32
 */
public class FilesTest {
    private static String from = "E:\\自学代码\\guava\\src\\main\\resources\\io\\1.txt";
    private static String to = "E:\\自学代码\\guava\\src\\main\\resources\\io\\2.txt";
    public static void main(String[] args) throws Exception {
        //guavacopyFiles();
        //javaNiocopyFiles();
        //guavamoveFiles();
        //guavaReadFiles();
        //guavaReadFilesProcess();
        //hashcodeFiles();
        //writeFiles();
        bianliFiles();
    }


    //复制文件,guava
    private static void guavacopyFiles() throws IOException {
        Files.copy(new File(from),new File(to));
    }


    //复制文件,java  NIO
    private static void javaNiocopyFiles() throws IOException {
        java.nio.file.Files.copy(Paths.get(from),
                Paths.get(to), StandardCopyOption.REPLACE_EXISTING);
    }

    //移动文件,java  NIO
    private static void guavamoveFiles() throws IOException {
        Files.move(new File(from),new File(to));

    }


    private static void guavaReadFiles() throws IOException {
        List<String> strings = Files.readLines(new File(to), Charsets.UTF_8);
        System.out.println(strings);

    }


    private static void guavaReadFilesProcess() throws IOException {
        LineProcessor<List<String>> lineProcessor = new LineProcessor<List<String>>() {
            List<String> list = new ArrayList<>();
            @Override
            public boolean processLine(String s) throws IOException {
                System.out.println("读到内容：" + s);
                list.add("SSS" + s);
                return true;   //return false,不再读取下面内容
            }

            @Override
            public List<String> getResult() {
                System.out.println("返回结果： "+ list);
                return list;
            }
        };
        List<String> strings = Files.asCharSource(new File(to), Charsets.UTF_8).readLines(lineProcessor);
        System.out.println(strings);
    }

    //计算文件hashcode (可对比两个文件是否一样)
    private static void hashcodeFiles() throws IOException {
        HashCode hash = Files.asByteSource(new File(to)).hash(Hashing.sha512());
        System.out.println(hash.toString());
    }


    //写文件
    private static void writeFiles() throws IOException {
        String path = "E:\\自学代码\\guava\\src\\main\\resources\\io\\rest.txt";
        File file = new File(path);
        Files.asCharSink(file,Charsets.UTF_8).write("hhhh");
        String read = Files.asCharSource(file, Charsets.UTF_8).read();
        System.out.println(read);

        //追加内容
        Files.asCharSink(file,Charsets.UTF_8, FileWriteMode.APPEND).write("\nhhhh2");
        String read2 = Files.asCharSource(file, Charsets.UTF_8).read();
        System.out.println(read2);
    }

    //遍历所有文件
    private static void bianliFiles() throws IOException {
        List<File> list = new ArrayList<>();
        String path = "E:\\自学代码\\guava\\src\\main";
        File file = new File(path);
       bianli(file,list);
        for (File file1 : list) {
            System.out.println(file1);
        }
    }

    private static void bianli(File file, List<File> list) {
        if (file.isHidden()) return;
        list.add(file);
        if (!file.isFile()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                bianli(file1,list);
            }
        }
    }


    //遍历所有文件
    private static void bianliFiles2() throws IOException {
        List<File> list = new ArrayList<>(); 
        String path = "E:\\自学代码\\guava\\src\\main";
        File file = new File(path);                //preOrderTraversal postOrderTraversal顺序不一样
        FluentIterable<File> files = Files.fileTreeTraverser().preOrderTraversal(file).filter(new Predicate<File>() {
            @Override
            public boolean apply(@Nullable File input) {
                return input.isFile();  //只要文件
            }
        });
        for (File file1 : files) {
            System.out.println(file1);
        }

        Iterable<File> children = Files.fileTreeTraverser().children(file);
    }
}
