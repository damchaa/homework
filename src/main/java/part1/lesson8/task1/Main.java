package part1.lesson8.task1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<MapEnity> list = Collections.synchronizedList(new ArrayList<MapEnity>());

        int[] arrays = new int[5];
        arrays[0] = 100;
        arrays[1] = 200;
        arrays[2] = 300;
        arrays[3] = 400;
        arrays[4] = 500;

        ExecutorService executor = Executors.newFixedThreadPool(3);
        MyThread myThread;
        for (int i:arrays){
            myThread  = new MyThread(i);
            executor.submit(myThread);
            list.add(myThread.getMapEnity());
        }
    }

}
