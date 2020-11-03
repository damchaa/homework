package part1.lesson4.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MathBox extends ObjectBox {

    private ArrayList<Number> list = new ArrayList<>();


    public MathBox(Number[] numbers) {
        for (Number number: numbers){
            list.add(number);
        }
    }

    public ArrayList<Number> getList() {
        return list;
    }

    public Number summator() {
        int summa = 0;
        for (Number number : list) {
            summa += number.intValue();
        }
        return summa;
    }

    public void splitter(int devisor) {
        ArrayList<Number> numbers = new ArrayList<>();
        for (Number value : list) {
            numbers.add(value.intValue() / devisor);
        }
        list.clear();
        list.addAll(numbers);
    }

    public void checkInteger(Integer integer) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(integer)) {
                list.remove(list.get(i));
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        part1.lesson4.task3.MathBox mathBox = (part1.lesson4.task3.MathBox) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "list=" + list +
                '}';
    }
}