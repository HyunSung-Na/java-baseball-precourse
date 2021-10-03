package baseball;

import baseball.game.Computer;
import baseball.game.RandomNumberComputer;
import baseball.game.fixedNumberComputer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {

    @DisplayName("랜덤 숫자를 생성한다 - 숫자들의 중복이 일어나지 않는다")
    @Test
    void createRandomNumber() {
        // given
        Computer computer = new RandomNumberComputer();

        // when
        List<Character> randomNumbers = computer.getNumber();

        // then
        assertThat(randomNumbers.size()).isEqualTo(3);
        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(1));
        assertThat(randomNumbers.get(1)).isNotEqualTo(randomNumbers.get(2));
        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(2));
    }
}
