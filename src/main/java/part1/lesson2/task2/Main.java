package part1.lesson2.task2;

public class Main {
    public static void main(String[] args) throws Exception {
        int size = (int) (Math.random() * 100);
        int[] array = new int[size];


        for (int i = 0; i < array.length; i++){
            int count = (int) (Math.random() * 200 - 100 );
            array[i] = count;
            if (array[i] < 0){
                throw new Exception();
            }
            else {
                if (array[i] == Math.pow((int) Math.sqrt(array[i]), 2)){
                    System.out.println(array[i]);
                }
            }
        }
    }
}
