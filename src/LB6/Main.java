package LB6;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public Main() {
    }
    public static void arrayCopy(int[] src, int srcPos, int[] dest, int destPos, int length) {
        while (length > 0){
            dest[destPos] = src[srcPos];
            srcPos++;
            destPos++;
            length--;
        }
    }
    public boolean compare_arrays(int[] arr1, int[] arr2) {
        //6 Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] по складу.
        // Масиви можуть відрізнятися по порядку елементів , но бути однаковими зі складу.
        // Приклад- [1,4,7]==[4,7,1- еквівалентні.]
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean b = true;
        if (arr1 != null & arr2 != null) {
            if (arr1.length != arr2.length)
                b = false;
            else
                for (int i = 0; i < arr2.length; i++) {
                    if (arr2[i] != arr1[i]) {
                        b = false;
                    }
                }
        } else {
            b = false;
        }
        return b;
    }

    @ParameterizedTest(name = "Test {index}: {0} and {1} are equals")
    @MethodSource("ArraysToCompare")
    void check1(int[] arr1, int[] arr2) {
        Assert.assertTrue(compare_arrays(arr1, arr2));
    }
    private static Stream<Arguments> ArraysToCompare() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 1, 2})
        );
    }

    public static int[] combination_arr(int[] arr3, int[] arr4)
    {
        //10 Створіть метод, який дозволяє поєднати між собою масиви int[]
        // та повернути результуючий масив з методу
        int[] a = new int[arr3.length+arr4.length];
        for (int i =0;i< a.length;i++)
        {
            a[i]=(i< arr3.length? arr3[i]:arr4[i-arr3.length]);
        }
        for(int j =0;j< a.length;j++)
        {
            System.out.print(a[j]+" ");
        }
        return a;

    }
    @ParameterizedTest(name = "Test {index}: {0} arr with {1} arr result => {2}")
    @MethodSource("ArraysToCombination")
    void check2(int[] arr1, int[] arr2, int[] expected) {
        Assert.assertArrayEquals(expected, combination_arr(arr1, arr2));
    }

    private static Stream<Arguments> ArraysToCombination() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 5, 6}, new int[]{3, 4}, new int[]{1, 2, 5, 6, 3, 4}),
                Arguments.of(new int[]{1}, new int[]{2}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 3, 4})
        );
    }

    public int[] insertion_sort_arr(int[] arr7)
    {
        //12 сортировка вставками
        for (int left = 0; left < arr7.length; left++) {
            // Вытаскиваем значение элемента
            int value = arr7[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < arr7[i]) {
                    arr7[i + 1] = arr7[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            arr7[i + 1] = value;
        }
        return arr7;
    }

    @ParameterizedTest(name = "Test {index}: {0} sorted => {1}")
    @MethodSource("ArraysToSort")
    void check3(int[] arr, int[] expected) {
        Assert.assertArrayEquals(expected, insertion_sort_arr(arr));
    }
    private static Stream<Arguments> ArraysToSort() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{8,7,6}, new int[]{6,7,8})
        );
    }

    public static int[] addElement(int[] arr, int elem, int pos)
    {   //3 Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число.
        // Метод повинен повертати новий масив.

        int[] after = new int[arr.length+1];//новый массив
        arrayCopy(arr,0,after,0,pos);
        after[pos] = elem;

        arrayCopy(arr,pos,after,pos+1,arr.length-pos);
        System.out.println(Arrays.toString(after));
        return after;
    }

    @ParameterizedTest(name = "Test {index}: {0} array add index {1} result = {2}")
    @MethodSource("ArraysAddElement")
    void check4(int[] arr, int elem, int pos , int[] excepted){
        Assert.assertArrayEquals(excepted, addElement(arr,elem,pos));
    }
    private static Stream<Arguments> ArraysAddElement(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6}, 6, 3 ,new int[]{1, 2, 3, 6, 4, 5, 6}),
                Arguments.of(new int[]{1,2,3}, 4, 0 ,new int[]{4, 1, 2, 3}),
                Arguments.of(new int[]{1,2,3}, 3, 1 ,new int[]{1, 3, 2, 3}),
                Arguments.of(new int[]{1,2,3}, 7, 2 ,new int[]{1, 2, 7, 3})
        );
    }

    public static int reverse(int value)
    {
        //7 Створіть метод , який може перевернути будь яку число int .
        // Приклад - 357 на вході, метод поверне 753
        int result = 0;
        while(value > 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }
        System.out.println(result);
        return result;
    }
    @ParameterizedTest(name = "Test {index}: {0} reverse = {1}")
    @CsvSource({"456,654","123,321"})
    void check5(int value, int expected) {
        Assert.assertEquals(reverse(value), expected);
    }
}
