package part1.lesson8.task1;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class MyThread  {

    int[] array;

    public MyThread(int[] array){
        this.array = array;
    }



    public void run() {
        BigInteger number = BigInteger.valueOf(1);
        for (int i = 0; i > 0; i--){
            number = BigInteger.valueOf(i).multiply(number);
        }
    }
}
