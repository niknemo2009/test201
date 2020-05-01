package LB6;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
Main ex = new Main();

    @DisplayName("\uD83D\uDC4D")
    @Test
    void deleteArrayTest(){
        int[] array ={1,2,3,4,5};
        int[] factResult=ex.deleteArray(array,2);
        int[] expectResult={1,2,4,5};
        assertArrayEquals(expectResult,factResult);
    }

    @org.junit.jupiter.api.Test
    void compareArr() {
    }

    @org.junit.jupiter.api.Test
    void intReverse() {
    }

    @org.junit.jupiter.api.Test
    void combinationArrTest() {
        int[] arr3 = new int[]{1,4,5,6};
        int[] arr4 = new int[]{7,8,9,2};
        int[] result = ex.combinationArr(arr3,arr4);
        int[] except_result = {1,4,5,6,7,8,9,2};
        assertArrayEquals(result,except_result);
    }


    @org.junit.jupiter.api.Test
    void selectionSortTest() {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] factResult = ex.selectionSort(arr);
        int[] exceptResult= {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(exceptResult,factResult);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void testWithStringParameter(String argument) {
        assertNotNull(argument);
    }

    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
    void testWithCsvSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }
    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @MethodSource("stringProvider")
    void test_method_string(String arg) {
        assertNotNull(arg);
    }
    static Stream<String> stringProvider() {
        return Stream.of("java", "rust");
    }

}