package baseball.game;

import java.util.List;

public class GameFactory {

    public static BaseBallGameController baseballGameController(UserInputManager userInputManager) {
        return new BaseBallGameController(userInputManager);
    }

    public static UserInputManager userInputManager() {
        return new UserInputManager();
    }

    public static BaseBallGame baseballGame(Computer computer) {
        return new BaseBallGame(computer);
    }

    public static Computer randomNumberComputer() {
        return new RandomNumberComputer();
    }

    public static GameView gameResultView() {
        return new GameView();
    }

    public static Computer fixedNumberComputer(List<Character> numbers) {
        return new fixedNumberComputer(numbers);
    }
}
