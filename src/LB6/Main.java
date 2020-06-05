package LB6;

import java.util.Arrays;
import java.util.stream.Stream;

/*import org.junit.Assert;*/
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Main {

    private Assertions Assert;

    public Main() {
    }
    //1++ -Створіть метод, який дозволяє видаляти будь який елемент по індексу
    // в одновимірному масиві int[] Новий масив повинен повертатися з методу.
    public int[] delete_element(int index, int[] arr) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index " + Integer.toString(index) + " out of bounds for length " + Integer.toString(arr.length));
        }
        int[] tmp = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                tmp[j] = arr[i];
                j++;
            }
        }
        return tmp;
    }
    //
    //2++ - Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] по складу.
    // Масиви можуть відрізнятися по порядку елементів , но бути однаковими зі складу.
    public boolean compare_arrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
    //
    //3-Створіть метод , який може перевернути будь яку число int .
    // Приклад - 357 на вході, метод поверне 753
    public int reverse(int number) {
        return Integer.parseInt(new StringBuilder(Integer.toString(number)).reverse().toString());
    }
    //
    //4-Створіть метод, який дозволяє поєднати між собою
    // масиви int[] та повернути результуючий масив з методу
    public int[] stick_arrays(int[] arr1, int[] arr2) {
        int general_length = 0;
        int current_length = 0;
        general_length = arr1.length + arr2.length;
        int[] new_array = new int[general_length];
        for (int i : arr1) {
            new_array[current_length] = i;
            current_length++;
        }
        for (int i : arr2) {
            new_array[current_length] = i;
            current_length++;
        }
        return new_array;
    }
    //
    //5-Створіть метод, який сортує будь який масив int[] методом вибору.
    public int[] insert_sort(int[] arr) {
        int i, j, tmp;
        int[] tmp_arr = arr.clone();
        for (i = 1; i < tmp_arr.length; i++) {
            tmp = tmp_arr[i];
            for (j = i - 1; j >= 0 && tmp_arr[j] > tmp; j--)
                tmp_arr[j + 1] = tmp_arr[j];
            tmp_arr[j + 1] = tmp;
        }
        return tmp_arr;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        int[] arr1 = {0, 1, 2, 3, 4};

    }

    @ParameterizedTest(name = "Test №{index}: element deleted on index {0}")
    @ValueSource(ints = {-1, 0, 4, 5})
    void check1(int index) {
        int[] arr = {0, 1, 2, 3, 4};
        try {
            delete_element(index, arr);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @ParameterizedTest(name = "Test №{index}: {0} and {1} are equals")
    @MethodSource("provideArraysToCompare")
    void check2(int[] arr1, int[] arr2) {
        Assert.assertTrue(compare_arrays(arr1, arr2));
    }


    private static Stream<Arguments> provideArraysToCompare() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 3, 5}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1})
        );
    }

    @ParameterizedTest(name = "Test №{index}: {1} is reverse of {0}")
    @CsvSource({"123,321", "111,111", "123,123"})
    void check3(int input, int expected) {
        Assert.assertEquals(reverse(input), expected);
    }

    @ParameterizedTest(name = "Test №{index}: {0} stick with {1} result => {2}")
    @MethodSource("provideArraysToStick")
    void check4(int[] arr1, int[] arr2, int[] expected) {
        Assert.assertTrue(Arrays.equals(expected, stick_arrays(arr1, arr2)));
    }

    private static Stream<Arguments> provideArraysToStick() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 3, 4, 5, 6}, new int[]{3, 4}, new int[]{4, 3, 6, 5, 4, 3, 1}),
                Arguments.of(new int[]{1}, new int[]{2}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 1, 2})
        );
    }

    @ParameterizedTest(name = "Test №{index}: {0} sorted => {1}")
    @MethodSource("provideArraysToSort")
    void check5(int[] arr, int[] expected) {
        Assert.assertTrue(Arrays.equals(expected, insert_sort(arr)));
    }

    private static Stream<Arguments> provideArraysToSort() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 0, -1}, new int[]{-1, 0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntsToReverse")
    public  void reverseTest(int number,int expected){
        Assert.assertEquals(expected,reverse(number));
    }
    private static Stream<Arguments> provideIntsToReverse()
    {
        return Stream.of(
                Arguments.of(123,321),
                Arguments.of(345,543)
        );
    }
}