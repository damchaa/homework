package part1.lesson4.task2;

public class Main {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        objectBox.addObject("String");
        objectBox.addObject(2);
        objectBox.deleteObject("String");
        objectBox.dump();
    }
}
