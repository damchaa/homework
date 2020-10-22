package part1.lesson2.task3;

import java.util.Arrays;
import java.util.Comparator;

public class FirstSort implements ArraySort {
    @Override
    public  void sortArray(Person[] people) {
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int sexResult = o1.getSex().compareTo(o2.getSex());
                if (sexResult != 0){
                    return sexResult;
                }

                if (o1.getAge() < o2.getAge()){
                    return 1;
                }
                else
                if (o1.getAge() > o2.getAge()){
                    return -1;
                }

                int nameResult = o1.getName().compareTo(o2.getName());
                return nameResult;

            }

        });
    }
}
