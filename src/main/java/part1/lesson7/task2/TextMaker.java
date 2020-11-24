package part1.lesson7.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextMaker {

    public static void getFiles(String path, int n, int size, String[] words, int probability)  {
        List<String> list = new ArrayList<>(n);
        List<File> files = new ArrayList<>(n);
        List<FileWriter> fileWriters = new ArrayList<>(n);
        int sizeText = size ;
        System.out.println(sizeText);
        for (int i = 1; i <=2;i++){
            list.add(path + "text" + i + ".txt");
            files.add(new File(path,  "text" + i + ".txt"));
            try {
                fileWriters.add(new FileWriter(path +"text" + i + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String string = "Hello world! ";

        String result = generateRandomWords(size);
        System.out.println(result);

        try {
            fileWriters.get(0).write(string);
            fileWriters.get(0).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generateRandomWords(int size)
    {
        String result = "";
        String del = " ";
        String[] signs = {"!","!","."};
        String[] substring;
        String[] predlojeniya;
        List<String> list = new ArrayList<>();

        Random random = new Random();

        while (result.length() <= size){
            char[] word = new char[random.nextInt(14)+1];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            result = result  + new String(word) + " ";

        }
        substring = result.split(del);




        return result;

    }
}
