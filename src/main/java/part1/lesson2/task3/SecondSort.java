package part1.lesson2.task3;

import java.util.Arrays;

public class SecondSort implements ArraySort {
    @Override
    public  void sortArray(Person[] people) {

        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if (people[j].getSex().equals(people[i].getSex())) {
                    Person p1 = people[j];
                    Person p2 = people[i];
                    people[j] = p1;
                    people[i] = p2;
                }
            }
        }

    }

}
