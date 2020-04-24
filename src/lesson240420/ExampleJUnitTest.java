package lesson240420;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExampleJUnitTest {
    ExampleJUnit ex=new ExampleJUnit();

    @org.junit.jupiter.api.Test
    void addElementTest() {

int array[]={1,2,3,4,5};
int[] factResult=ex.addElement(array,7);
int[] expectResult={1,2,3,4,5,7};
assertArrayEquals(expectResult,factResult);

    }
    @org.junit.jupiter.api.Test
    void addElementTest2() {

        int array[]={};
        int[] factResult=ex.addElement(array,7);
        int[] expectResult={7};
        assertArrayEquals(expectResult,factResult);

    }
@DisplayName("!!!!!!!!!!!!!!!!!!")
    @ParameterizedTest
@MethodSource("sourceMetod")
    void  convertTest(int ball,int expectRes){

      int factResult=ex.convert(ball);
      assertEquals(expectRes,factResult);
    }
    //  30 59 60 61 68 74 75 76 80 89 90 91 110
    static Stream<Arguments> sourceMetod(){
        return Stream.of(
          Arguments.arguments(30,2),
          Arguments.arguments(59,2),
          Arguments.arguments(60,3),
          Arguments.arguments(61,3),
          Arguments.arguments(74,3),
          Arguments.arguments(75,4),
          Arguments.arguments(76,4),
          Arguments.arguments(80,4),
          Arguments.arguments(90,5),
          Arguments.arguments(91,5),
          Arguments.arguments(110,5)

        );
    }
}