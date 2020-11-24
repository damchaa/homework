package part1.lesson7.task2;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Project\\";
        int n = 2;
        int size = 32768;
        String[] words = {"mama","mila","ramy"};
        int probability = 2;

        TextMaker.getFiles(path,n,size,words,probability);
    }
}
