package part1.lesson5.task1;

import java.util.*;

public class WorkerWithList {
    private static Set<Animal> animals = new HashSet<>();
    public static void addToSet(Animal animal){
        animals.add(animal);
    }
    public static Animal findById(Set<Animal> animals, int id){
        for (Animal animal: animals){
            if (animal.getId() == id){
                return animal;
            }
        }
        return null;
    }
    public static void setDataAnimal(int id, Person person){
        for (Animal animal: animals){
            if (animal.getId() == id){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите имя: ");
                animal.setName(scanner.nextLine());
                System.out.println("Введите вес: ");
                animal.setWeight(scanner.nextInt());


                animal.setPerson(person);
                System.out.println(animal);
            }
        }

    }
    public static void sortByName(){
        SortedSet<Animal> animals1 = new TreeSet<>(new Comparator<Animal>() {
            @Override

            public int compare(Animal o1, Animal o2) {
                int compareble = o1.getName().compareTo(o2.getName());
                return compareble;
            }
        });
        animals1.addAll(animals);
        for (Animal animal: animals1){
            System.out.println(animal);
        }

    }
    public static void sortByWeight(){
        SortedSet<Animal> animals1 = new TreeSet<>(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (o1.getWeight() > o2.getWeight()){
                    return 1;
                }
                else
                if (o1.getWeight() < o2.getWeight()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        animals1.addAll(animals);
        for (Animal animal: animals1){
            System.out.println(animal);
        }
    }

    public static void sortByPerson(){
        SortedSet<Animal> animals1 = new TreeSet<>(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                int compareble = o1.getPerson().getName().compareTo(o2.getPerson().getName());
                return compareble;
            }
        });
        animals1.addAll(animals);
        for (Animal animal: animals1){
            System.out.println(animal);
        }
    }
}
