package part1.lesson4.task3;



public class Main {
    public static void main(String[] args)   {
        Number[] numbers = new Number[3];
        numbers[0] = 4;
        numbers[1] = 32;
        numbers[2] = 128;

        Object object = new Object();

        ObjectBox objectBox = new MathBox(numbers);
        System.out.println(objectBox);

        objectBox.dump();


    }
}
