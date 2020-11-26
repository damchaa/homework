package part1.lesson10.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = createClass();
        FileWriter fileWriter;




    }
    public static List<String> createClass(){
        ArrayList<String> list = new ArrayList<>();
        list.add("package part1.lesson10.task1;");
        list.add("public class SomeClass implements Worker {");
        list.add("@Override");
        list.add("public void doWork() {");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            if (s.equals("")){
                break;
            }
            list.add(s);
        }
        list.add("}");
        list.add("}");






                return list;
    }
}
