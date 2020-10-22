package part1.lesson5.task1;

import java.util.Objects;

public class Animal  {
    private int id;
    private String name;
    private Person person;
    private int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                weight == animal.weight &&
                Objects.equals(name, animal.name) &&
                Objects.equals(person, animal.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, person, weight);
    }

    public Animal(int id, String name, Person person, int weight){
        this.id = id;
        this.name = name;
        this.person = person;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }


}