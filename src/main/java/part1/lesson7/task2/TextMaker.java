package part1.lesson7.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextMaker {
    private static Random random = new Random();
    public static void getFiles(String path, int n, int size, String[] words, int probability)  {
        List<String> list = new ArrayList<>(n);
        List<File> files = new ArrayList<>(n);
        List<FileWriter> fileWriters = new ArrayList<>(n);
        int sizeText = size ;


        System.out.println(sizeText);

        for (int i = 1; i <=n;i++){
            list.add(path + "text" + i + ".txt");
            files.add(new File(path,  "text" + i + ".txt"));
            try {
                fileWriters.add(new FileWriter(path +"text" + i + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String result = generateRandomWords(size);
        List<String> app = createApp(result,probability);
        String s= createParagraph(app);


        try {
            fileWriters.get(0).write(result);
            fileWriters.get(0).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generateRandomWords(int size)
    {
        String result = "";
        while (result.length() <= size){
            char[] word = new char[random.nextInt(14)+1];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            result = result  + new String(word) + " ";
        }

        return result;

    }
    public static List<String> createApp(String result,int probability){
        List<String> application = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String del = " ";
        String[] signs = {"!","?","."};
        String[] substring;
        substring = result.split(del);
        String word = getWordFromArray();
        int count = 0;
        int count2 = 0;
        while (count <= substring.length){
            count = random.nextInt(15) + count2  ;
            String helpString = " ";
            for (int i = count2; i <=count; i++ ){
                if (i >= substring.length){
                    break;
                }
                helpString = helpString + substring[i] + " ";
                count2 = count+1 ;
            }
            list.add(helpString);
        }
        String[] strings = new String[list.size()];

        for (int i = 0; i< list.size();i ++){
            strings[i] = list.get(i);
        }
        for (int i = 0; i< list.size();i += probability){
            if (i>list.size()){
                break;
            }
            strings[i] += word;
        }
        for (String s: strings){
            application.add(s + signs[random.nextInt(3)]);
        }
        return application;
    }
    public static String getWordFromArray(){
        FileInputStream FileReader = null;

        try {
            FileReader = new FileInputStream("D:\\Project\\array.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inStream = new InputStreamReader(FileReader);
        BufferedReader bufReader = new BufferedReader(inStream);
        ArrayList<String> list = new ArrayList<>();
        String s = null;
        while (true){
            try {
                if (!((s = bufReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(s);

        }
        return list.get(random.nextInt(list.size()));
    }
    public static String createParagraph(List<String> list){
        int sizeParagraph = 3;
        String[] sublist = new String[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            sublist[i]=list.get(i);
        }
        List<String> text = new ArrayList<>();
        int count=0;
        int count2=sizeParagraph;
        String s ="";

        while (count <= sublist.length){
            String s1 = "";

            for (int i = count; i < sizeParagraph; i++) {
                if (sizeParagraph >list.size()){
                    break;
                }
                s1 +=sublist[i];

            }
            text.add(s1+System.lineSeparator());
            count += count2;
            sizeParagraph+=count2;

        }
        String[] finalText = new String[text.size()];
        for (int i = 0; i < text.size(); i++) {
            finalText[i] =text.get(i);
        }


        return null;
    }

}
