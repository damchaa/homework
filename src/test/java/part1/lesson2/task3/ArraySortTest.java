package part1.lesson2.task3;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static part1.lesson2.task3.Sex.MAN;
import static part1.lesson2.task3.Sex.WOMAN;

class ArraySortTest {

    @Test
    public void exampleEasyTest(){
        Person[] unsorted = getUnsortedArray();
        Person[] sorted = sortArray(unsorted);
        FirstSort algorithm = new FirstSort();
        algorithm.sortArray(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void exampleParameterizedTest(Person[] actual, Person[] expected, ArraySort algorithm) {
        algorithm.sortArray(actual);
        assertArrayEquals(actual, expected);
    }

    public static Stream<Arguments> getTestData() {
        Person[] unsorted = getUnsortedArray();
        Person[] sorted = sortArray(unsorted);

        printArray("actual array:", unsorted);
        printArray("expected array:", sorted);

        return Stream.of(
                Arguments.of(Arrays.copyOf(unsorted, unsorted.length), sorted, new FirstSort()),
                Arguments.of(Arrays.copyOf(unsorted, unsorted.length), sorted, new SecondSort())
        );
    }

    private static Person[] getUnsortedArray() {
        return new Person[] {
                new Person(7, "name1", MAN),
                new Person(7, "name2", MAN),
                new Person(4, "name3", MAN),
                new Person(4, "name1", MAN),
                new Person(8, "name1", MAN),
                new Person(6, "name1", MAN),
                new Person(9, "name2", MAN),
                new Person(6, "name2", MAN),
                new Person(7, "name2", WOMAN),
                new Person(8, "name2", WOMAN),
                new Person(6, "name2", WOMAN),
                new Person(9, "name2", WOMAN),
                new Person(9, "name5", MAN),
                new Person(5, "name2", WOMAN),
                new Person(5, "name", WOMAN),
                new Person(6, "name", WOMAN),
                new Person(7, "name", WOMAN),
                new Person(5, "name1", MAN)
        };
    }

    private static <T> void printArray(String message, T[] array) {
        System.out.println(message);
        Arrays.stream(array).forEach(System.out::println);
    }

    /**
     * @return отсортированный по требуемым правилам дубликат массива
     */
    private static Person[] sortArray(Person[] people) {
        return Arrays.stream(people).sorted((a, b) -> {
            int order;
            if ((order = a.getSex().compareTo(b.getSex())) != 0) {
                return order;
            }
            if ((order = Integer.compare(b.getAge(), a.getAge())) != 0) {
                return order;
            }
            if ((order = a.getName().compareTo(b.getName())) != 0) {
                return order;
            }
            return order;
        }).toArray(Person[]::new);
    }
}