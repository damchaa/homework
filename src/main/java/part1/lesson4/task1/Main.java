package part1.lesson4.task1;

public class Main {
    public static void main(String[] args) {
        Number[] numbers = new Number[3];
        numbers[0] = 4;
        numbers[1] = 32;
        numbers[2] = 128;
        MathBox mathBox = new MathBox(numbers);
        System.out.println(mathBox.summator());
        System.out.println("");
        System.out.println("");
        System.out.println(mathBox.getList());
        System.out.println("");
        mathBox.splitter(2);
        System.out.println("");
        System.out.println("");
        System.out.println(mathBox.getList() );
    }
}
