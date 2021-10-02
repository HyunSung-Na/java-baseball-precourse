package studyTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}