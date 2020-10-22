package part1.lesson2.task3;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[6];

        Person danil = new Person(23,"Danil", Sex.MAN);
        Person ilya = new Person(24, "Ilya", Sex.MAN);
        Person kolob = new Person(24, "Kolob", Sex.MAN);
        Person marina = new Person(24, "Marina", Sex.WOMAN);
        Person katya = new Person(24,"Katya", Sex.WOMAN);
        Person elvina = new Person(23, "Elvina", Sex.WOMAN);


        people[5] = danil;
        people[1] = ilya;
        people[2] = kolob;
        people[3] = marina;
        people[4] = katya;
        people[0] = elvina;
        System.out.println(people[2].getName().compareTo(people[1].getName()));

        sortArray(people);
        for (Person person: people){
            System.out.println(person);
        }

        System.out.println();
        System.out.println();

        FirstSort firstSort = new FirstSort();
        firstSort.sortArray(people);
        for (Person person: people){
            System.out.println(person);
        }

    }
    public static void sortArray(Person[] people) {
        for (int i = 0; i < people.length; i++){
            for (int j = 0; j < people.length-1; j++){
                if (people[j].getName().compareTo(people[j +1].getName()) > 0 ){
                    Person person;
                    person = people[j];                            // если истино, то меняем
                    people[j] = people[j + 1];                    // местами элементы
                    people[j + 1] = person;
                }
                if (people[j].getAge() < people[j +1].getAge()){
                    Person person;
                    person = people[j];                            // если истино, то меняем
                    people[j] = people[j + 1];                    // местами элементы
                    people[j + 1] = person;
                }
                if (people[j].getSex().compareTo(people[j +1].getSex()) > 0 ){
                    Person person;
                    person = people[j];                            // если истино, то меняем
                    people[j] = people[j + 1];                    // местами элементы
                    people[j + 1] = person;
                }
            }
        }



    }


}
