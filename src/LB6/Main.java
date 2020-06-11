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
        String number1 =String.valueOf(number);
        char[] arr = number1.toCharArray();
        char[] res = new char[arr.length];
        //От длины массива отнимается значение.
        for(int i=0;i<arr.length;i++)
        {
            res[res.length - i - 1]=arr[i];
        }
        String res1 = new String(res);
        int res2 = Integer.parseInt(res1);
        System.out.println(res2);
        return res2;
    }
    //
    //4-Створіть метод, який дозволяє поєднати між собою
    // масиви int[] та повернути результуючий масив з методу
    public int[] stick_arrays(int[] arr1, int[] arr2) {
        int general_length;
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
    public int[] selected_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }

        }
        return arr;
    }

    @ParameterizedTest(name = "Тест {index}: элемент удалён по индексу {0}")
    @DisplayName("Удаление элементов массива по индексу")
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

    @ParameterizedTest(name = "Тест {index}: {0} и {1} еквивалентны")
    @DisplayName("Сравнение массивов")
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

    @ParameterizedTest(name = "Тест {index}: {1} развёрнутый {0}")
    @DisplayName("Перевёрнутое число")
    @CsvSource({"123,321", "111,111", "123,123"})
    void check3(int input, int expected) {
        Assert.assertEquals(reverse(input), expected);
    }

    @ParameterizedTest(name = "Тест {index}: {0} вместе с  {1} даёт результат = {2}")
    @DisplayName("Соединение массивов")
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

    @ParameterizedTest(name = "Тест {index}: {0} отсортированный = {1}")
    @DisplayName("Сортировка выбором")
    @MethodSource("provideArraysToSort")
    void check5(int[] arr, int[] expected) {
        Assert.assertTrue(Arrays.equals(expected, selected_sort(arr)));
    }

    private static Stream<Arguments> provideArraysToSort() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 0, -1}, new int[]{-1, 0, 1})
        );
    }
}