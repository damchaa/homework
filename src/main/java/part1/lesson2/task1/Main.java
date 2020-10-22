package part1.lesson2.task1;

public class Main {
        public static void main(String[] args) throws Exception {
            String string = null;
            String[] strings = new String[1];
            try {
                System.out.println(string.length());
            }
            catch (NullPointerException e){
                System.out.println("Hello World");
            }
            try {
                System.out.println(strings[3]);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Hello World");
            }
            throw new TestException("Hello world");
        }
}

