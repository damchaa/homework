package part1.lesson12.task1;


import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<MapEnity> list = Collections.synchronizedList(new ArrayList<MapEnity>());

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(55555);


        ExecutorService executor = Executors.newFixedThreadPool(3);
        integers.stream().forEach(integer -> executor.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        BigInteger number = BigInteger.valueOf(1);
                        MapEnity mapEnity;
                        for (int k = integer; k > 0; k--) {
                            number = BigInteger.valueOf(k).multiply(number);

                        }
                        mapEnity = new MapEnity(integer, number);
                        list.add(mapEnity);
                        System.out.println(mapEnity);
                    }
                }
        ));




    }

}
