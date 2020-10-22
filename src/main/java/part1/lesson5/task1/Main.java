package part1.lesson5.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Animal> animals = new HashSet<>();

        Person danil = new Person("Danil",23, true);
        Animal cat = new Animal(1,"Stepa", danil, 5);

        Person ilya = new Person("Ilya",24, true);
        Animal dog = new Animal(2, "Monica", ilya, 20);

        Person marina = new Person("Marina", 24,false);
        Animal fish = new Animal(3,"Nemo", marina, 1);

        Person kolob = new Person("Kolob", 24, true);
        Animal buldog = new Animal(4,"Jessica", kolob, 25);

        animals.add(cat);
        animals.add(dog);
        animals.add(fish);
        animals.add(buldog);

        Sort.sortByName(animals);
        Sort.sortByWeight(animals);
        Sort.sortByPerson(animals);
    }

}