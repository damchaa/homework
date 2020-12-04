package part1.lesson8.task1;


import java.math.BigInteger;
import java.util.List;


public class MyThread implements Runnable {
    //Future
    private int count;
    private MapEnity mapEnity;
    private static List<MapEnity> mapEnityList;

    public MyThread(int count) {
        this.count = count;
    }

    public void run() {

        BigInteger number = BigInteger.valueOf(1);
        for (int k = count; k > 0; k--) {
            number = BigInteger.valueOf(k).multiply(number);

        }
        mapEnity = new MapEnity(count, number);
        System.out.println(mapEnity);

    }

    public MapEnity getMapEnity() {
        return mapEnity;
    }
}
