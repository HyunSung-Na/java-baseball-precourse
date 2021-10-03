package baseball.game;

import java.util.List;

public class GameFactory {
    public static BaseBallGame baseballGame(Computer computer) {
        return new BaseBallGame(computer);
    }

    public static Computer randomNumberComputer() {
        return new RandomNumberComputer();
    }

    public static GameResultView gameResultView() {
        return new GameResultView();
    }

    public static Computer fixedNumberComputer(List<Character> numbers) {
        return new fixedNumberComputer(numbers);
    }
}
