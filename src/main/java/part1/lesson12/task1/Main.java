package part1.lesson12.task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        integers.add(5);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        integers.stream().forEach(integer -> executor.submit(new MyThread(integer)));

    }

}
