package part1.lesson10.task1;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = createClass();
        String path = "src\\main\\java\\part1\\lesson10\\task1\\SomeClass.java";
        writeClass(path,list);
        compileClass(path);

        try {
            MyClassLoader myClassLoader = new MyClassLoader();
            Class c  = myClassLoader.findClass("SomeClass");
            Method m = c.getMethod("doWork");
            m.invoke(c.newInstance());




        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void writeClass(String path,List<String> list){
        try {
            FileWriter fileWriter = new FileWriter(path);
            for (String s: list){
                fileWriter.write(s + System.lineSeparator());
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void compileClass(String path){
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

            List<File> sourceFileList = new ArrayList<File>();
            sourceFileList.add(new File(path));
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null,null, compilationUnits);
            task.call();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<String> createClass() {
        ArrayList<String> list = new ArrayList<>();
        list.add("package part1.lesson10.task1;");
        list.add("public class SomeClass implements Worker {");
        list.add("@Override");
        list.add("public void doWork() {");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("")) {
                break;
            }
            list.add(s);
        }
        list.add("}");
        list.add("}");
        return list;
    }
}
