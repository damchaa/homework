package part1.lesson2.task3;

public class Person {
    private int age;
    private String name;
    private Sex sex;

    public Person(int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return sex == person.sex;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
