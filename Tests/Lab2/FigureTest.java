package Lab2;


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


public class FigureTest{

    @ParameterizedTest(name = "Тест {index} = {5}")
    @DisplayName("Figure square")
    @MethodSource("provideFigure")
    void check1(Figure f1, Rectangle r1, Triangle t1, Square s1, Trapeze tz1, int expected) {

        Assert.assertEquals(f1.RetSquare(r1, t1, s1, tz1), expected);
    }

    private static Stream<Arguments> provideFigure() {
        return Stream.of(
                Arguments.of(new Figure(), new Rectangle(0, 0, 0, 4, 5, 4, 5, 0),
                        new Triangle(2,3,4,5,2,6),
                        new Square(2,10,2,15,7,15,7,10),
                        new Trapeze(0,0,2,5,7,5,9,0),
                        83)
        );
    }
}