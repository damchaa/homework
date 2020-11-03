package part1.lesson10.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        SomeClass someClass = new SomeClass();
        String string = "int a = 2";

//        while (true){
//            string = scanner.nextLine();
//            if (string.equals(" ")){
//                break;
//            }
//            list.add(string);
//        }
//
//        for (String stroke: list){
//            System.out.println(stroke);
//        }
        System.out.println();
        Class clazz = Class.forName("SomeClass");
        Method targetMethod = clazz.getDeclaredMethod("doWork");


        System.out.println(targetMethod);



    }
}
