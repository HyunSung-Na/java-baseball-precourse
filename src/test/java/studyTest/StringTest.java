package studyTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void split_1과_2로_잘_분리되는지_확인() {
        // given
        String splitWord = ",";
        String numbers = "1,2";

        // when
        String[] splitString = numbers.split(splitWord);

        // then
        assertThat(splitString).contains("1");
        assertThat(splitString).contains("2");
        assertThat(splitString).containsExactly("1", "2");
    }

    @Test
    void substring_문자열의_앞과_뒤를_분리되는지_확인() {
        // given
        String numbers = "(1,2)";
        int start = 1;
        int end = numbers.length() - 1;

        // when
        String substring = numbers.substring(start, end);

        // when
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    @Test
    void charAt_특정위치의_문자를_가져온다() {
        // given
        String alpha = "abc";

        // when
        char charAtA = alpha.charAt(0);
        char charAtB = alpha.charAt(1);
        char charAtC = alpha.charAt(2);

        // then
        assertThat(charAtA).isEqualTo('a');
        assertThat(charAtB).isEqualTo('b');
        assertThat(charAtC).isEqualTo('c');
    }

    @DisplayName("위치를 벗어난 문자를 조회시 예외가 발생하는지 확인하는 테스트")
    @Test
    void charAt_문자의_범위를_벗어난_위치를_조회한다() {
        // given
        String alpha = "abc";

        // then
        assertThatThrownBy(() -> {
            alpha.charAt(100);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 100");
    }
}
