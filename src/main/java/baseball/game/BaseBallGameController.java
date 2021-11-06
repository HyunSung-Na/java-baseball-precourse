package baseball.game;

import static baseball.game.UserInputManager.GAME_END_NUMBER;

public class BaseBallGameController {

    private final UserInputManager userInputManager;
    private final GameView gameView = GameFactory.gameResultView();

    public BaseBallGameController(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
    }

    public void playGame() {
        BaseBallGame baseBallGame = GameFactory.baseballGame(GameFactory.randomNumberComputer());
        gameView.viewStartMessage();
        while (!baseBallGame.changeUp(userInputManager.playerInputData())) {
            gameView.viewGameMessage(baseBallGame.getStrike(), baseBallGame.getBall());
            baseBallGame.initStrikeAndBallCount();
            gameView.viewStartMessage();
        }
        gameView.gameSuccessMessage();
        if (gameEndingCheckUserSelect()) { return; }

        playGame();
    }

    private boolean gameEndingCheckUserSelect() {
        gameView.viewGameSystemMessage();
        int userSelectedInput = userInputManager.isReStartGameSelectUserInput();

        if (userSelectedInput == GAME_END_NUMBER) {
            gameView.viewGameEndMessage();
            return true;
        }

        return false;
    }
}
