package part1.lesson4.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MathBox<T extends Number> extends ObjectBox<T>{




    public MathBox(T[] numbers) {
        super(numbers);
    }

    public List<T> getList() {
        return super.getList();
    }

    public Number summator() {
        int summa = 0;
        for (T number : getList()) {
            summa += number.intValue();
        }
        return summa;
    }

    public void splitter(int devisor) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (T value : super.getList()) {
            numbers.add(value.intValue() / devisor);
        }
        getList().clear();
        getList().addAll((Collection<? extends T>) numbers);
    }

    public void checkInteger(Integer integer) {
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).equals(integer)) {
                getList().remove(getList().get(i));
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        part1.lesson4.task3.MathBox mathBox = (part1.lesson4.task3.MathBox) o;
        return Objects.equals(getList(), mathBox.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList());
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "list=" + getList() +
                '}';
    }
}