package baseball;

import baseball.game.BaseBallGameController;
import baseball.game.GameFactory;
import baseball.game.UserInputManager;

public class Application {
    public static void main(String[] args) {
        UserInputManager userInputManager = GameFactory.userInputManager();
        BaseBallGameController baseBallGameController = GameFactory.baseballGameController(userInputManager);

        baseBallGameController.playGame();
    }
}
