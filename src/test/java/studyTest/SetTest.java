package studyTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size를 확인한다")
    @Test
    void setSizeTest() {
        // when
        int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(3);
    }

    @DisplayName("Set의 구성요소를 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void is_Match_set_numbers(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 구성요소의 예외 사항을 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void is_Match_set_numbers_csv_test(String input, String expect) {
        int inputValue = Integer.valueOf(input);
        boolean expectValue = Boolean.valueOf(expect);

        assertThat(numbers.contains(inputValue)).isEqualTo(expectValue);
    }
}
