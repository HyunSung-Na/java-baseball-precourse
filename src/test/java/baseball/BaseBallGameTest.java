package baseball;

import baseball.game.BaseBallGame;
import baseball.game.Computer;
import baseball.game.GameFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseBallGameTest {

    List<Character> numbers;
    Computer computer;
    BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add('1');
        numbers.add('2');
        numbers.add('3');

        computer = GameFactory.fixedNumberComputer(numbers);
        baseBallGame = GameFactory.baseballGame(computer);
    }

    @DisplayName("야구 게임 - 3 스트라이크")
    @Test
    void 스트라이크를_3개_한다() {
        // when
        baseBallGame.countStrikeAndBall(123);

        // then
        assertThat(baseBallGame.getStrike()).isEqualTo(3);
        assertThat(baseBallGame.getBall()).isEqualTo(0);
    }

    @DisplayName("야구 게임 - 3 볼")
    @Test
    void 볼을_3개_한다() {
        // when
        baseBallGame.countStrikeAndBall(312);

        // then
        assertThat(baseBallGame.getStrike()).isEqualTo(0);
        assertThat(baseBallGame.getBall()).isEqualTo(3);
    }

    @DisplayName("야구 게임 - 게임 승리 여부를 판정한다")
    @ParameterizedTest
    @CsvSource(value = {"123,true", "321,false", "456,false"}, delimiter = ',')
    void 스트라이크_볼_판정(String input, String expect) {
        int inputValue = Integer.valueOf(input);
        boolean expectValue = Boolean.valueOf(expect);

        assertThat(baseBallGame.changeUp(inputValue)).isEqualTo(expectValue);
    }
}
