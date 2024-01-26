package lesson.java.statics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("더하기")
    @Test
    void plus(){
        // given
        int num1 = 1;
        int num2 = 2;

        // when
        int result = Calculator.plus(num1, num2);

        // then
        assertEquals(3, result);
    }

    @DisplayName("빼기")
    @Test
    void minus(){
        // given
        int num1 = 1;
        int num2 = -2;

        // when
        int result = Calculator.minus(num1, num2);

        // then
        assertEquals(-1, result);

    }

    @DisplayName("곱하기")
    @Test
    void multiply(){
        // given
        int num1 = -2;
        int num2 = 5;

        // when
        int result = Calculator.multiply(num1, num2);

        // then
        assertEquals(-10, result);
    }

    @DisplayName("나누기")
    @Test
    void divide(){
        // given
        int num1 = 1;
        int num2 = -2;

        // when
        double result = Calculator.divide(num1, num2);

        // then
        assertEquals(-0.5, result);
    }


}