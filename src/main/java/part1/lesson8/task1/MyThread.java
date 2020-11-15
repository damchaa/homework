package part1.lesson8.task1;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class MyThread implements Runnable {

    private int[] array;

    public MyThread(int[] array){
        this.array = array;
    }



    public void run() {
        for (int i = 0; i< array.length; i++) {
            int count = i;
            BigInteger number = BigInteger.valueOf(1);
            for (int k = array[count]; k > 0; k--){
                number = BigInteger.valueOf(k).multiply(number);
            }
            System.out.println(number);
        }
    }
}
