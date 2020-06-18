package Lab2;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class MainTest{
    @ParameterizedTest(name = "Тест {index} = {0}")
    @DisplayName("Filter")
    @ValueSource(ints = {-1, 0, 4, 5})
    void check1(int index) {
        MyFilter f1 = new Filter();
        Main m = new Main();

        int[] arr = {-3, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        try {
            m.filt(arr,f1,index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();

        }
    }


    @ParameterizedTest(name = "Тест {index} = {0}")
    @DisplayName("Month")
    @MethodSource("monthCheck")
    void check2(Month m1, int expected) {

        Assert.assertEquals(m1.GetDays(), expected);
    }

    private static Stream<Arguments> monthCheck() {
        return Stream.of(
                Arguments.of(Month.June, 30),
                Arguments.of(Month.January, 30),
                Arguments.of(Month.December, 31)
        );
    }
}