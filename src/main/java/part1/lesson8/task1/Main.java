package part1.lesson8.task1;

import java.math.BigInteger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {


        int[] arrays = new int[5];
        arrays[0] = 1;
        arrays[1] = 2;
        arrays[2] = 3;
        arrays[3] = 4;
        arrays[4] = 5;


        ExecutorService executor = Executors.newSingleThreadExecutor();
        MyThread myThread = new MyThread(arrays);
        executor.submit(myThread);

    }


}
