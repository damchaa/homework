package part1.lesson5.task1;

public class Person  {
    private String name;
    private int age;
    private boolean man;

    public Person(String name, int age, boolean man){
        this.name = name;
        this.age = age;
        this.man = man;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", man=" + man +
                '}';
    }


}