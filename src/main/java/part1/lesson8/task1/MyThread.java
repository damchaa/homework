package part1.lesson8.task1;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class MyThread implements Runnable {
//Future
    private int count;
    private List<BigInteger> list = Collections.synchronizedList(new ArrayList<>());
    public MyThread(int count){
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "list=" + list +
                '}';
    }

    public List<BigInteger> getList() {
        return list;
    }

    public void run() {

            BigInteger number = BigInteger.valueOf(1);
            for (int k = count; k > 0; k--){
                number = BigInteger.valueOf(k).multiply(number);
            }
            System.out.println(number);
            addToList(number);
        }

    public void addToList(BigInteger key){
        list.add(key);
    }
}
