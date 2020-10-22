package part1.lesson7.task1;

import java.io.*;
import java.util.*;

public class FileWorker {
    public  void  canWrite(String string1,String string2) throws IOException {
        FileInputStream FileReader = new FileInputStream(string1);
        InputStreamReader inStream = new InputStreamReader(FileReader);
        BufferedReader bufReader = new BufferedReader(inStream);
        ArrayList<String> list = new ArrayList<>();
        String s = null;
        while ((s = bufReader.readLine()) != null){
            list.add(s);

        }

        inStream.close();
        bufReader.close();
        Collections.sort(list);

        Set<String> stringSet = new TreeSet<>();
        stringSet.addAll(list);
        for (String string: stringSet){
            System.out.println(string);;
        }
        FileWriter writer = new FileWriter(string2);
        for (String string: stringSet){
            writer.write(string + System.getProperty("line.separator"));
        }
        writer.close();
    }


}
