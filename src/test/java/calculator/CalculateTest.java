package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    @Test
    void plus() {
        Calculator cal = new Calculator("3").plus(new Calculator(2));
        assertThat(cal).isEqualTo(new Calculator(5));
    }

    @Test
    void minus() {
        Calculator cal = new Calculator(3).minus(new Calculator(2));
        assertThat(cal).isEqualTo(new Calculator(1));
    }

    @Test
    void multiple() {
        Calculator cal = new Calculator("3").multiple(new Calculator("2"));
        assertThat(cal).isEqualTo(new Calculator(6));
    }

    @Test
    void divide() {
        Calculator cal = new Calculator(4).divide(new Calculator(2));
        assertThat(cal).isEqualTo(new Calculator(2));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3"})
    void testCalculatorAdd(int a, int b, int expected) {
        assertThat(expected).isEqualTo(new Calculator(a).plus(new Calculator(b)).getNumber());
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3:6", "4 / 2 + 1:3", "3 - 1 * 5:10", "4 / 2:2"}, delimiter = ':')
    void testCalculatorAdd(String a, int b) {
        assertThat(b).isEqualTo(Calculate.calculate(a));
    }
}
