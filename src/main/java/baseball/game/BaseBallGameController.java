package baseball.game;

import static baseball.game.GameMessage.*;
import static baseball.game.UserInputManager.GAME_END_NUMBER;

public class BaseBallGameController {

    private final UserInputManager userInputManager;
    private BaseBallGame baseBallGame;

    public BaseBallGameController(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    public void playGame() {
        baseBallGame = GameFactory.baseballGame(GameFactory.randomNumberComputer());
        System.out.print(GAME_START_MESSAGE);
        while (!baseBallGame.changeUp(userInputManager.playerInputData())) {
            System.out.print(GAME_START_MESSAGE);
        }
        if (gameEndingCheckUserSelect()) { return; }

        playGame();
    }

    private boolean gameEndingCheckUserSelect() {
        System.out.println(GAME_SYSTEM_MESSAGE);
        int userSelectedInput = userInputManager.isReStartGameSelectUserInput();

        if (userSelectedInput == GAME_END_NUMBER) {
            System.out.println(GAME_END_MESSAGE);
            return true;
        }

        return false;
    }
}
