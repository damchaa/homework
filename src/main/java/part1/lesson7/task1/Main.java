package part1.lesson7.task1;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String start = "D://start.txt";
        String result = "D://result.txt";
        FileWorker fileWorker = new FileWorker();
        fileWorker.canWrite(start,result);
    }
}
