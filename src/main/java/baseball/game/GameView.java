package baseball.game;

import static baseball.game.BaseBallGame.GAME_END_CONDITION_NUMBER;
import static baseball.game.GameMessage.*;

public class GameView {
    private final static int gameMessageStartIndex = 0;

    private final StringBuilder gameMessage = new StringBuilder();

    void viewGameMessage(int strike, int ball) {
        checkStrikeMessage(strike);
        checkBallMessage(ball);
        checkNotingMessage(strike, ball);

        System.out.println(gameMessage);
        gameMessage.delete(gameMessageStartIndex, gameMessage.length());
    }

    private void checkBallMessage(int ball) {
        if (ball > 0) {
            gameMessage.append(ballMessage(ball));
        }
    }

    private void checkStrikeMessage(int strike) {
        if (strike > 0) {
            gameMessage.append(strikeMessage(strike));
        }
    }

    private void checkNotingMessage(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            gameMessage.append(NOT_MATCH_STRIKE_BALL_MESSAGE);
        }

    }

    public void gameSuccessMessage() {
        System.out.println(strikeMessage(GAME_END_CONDITION_NUMBER));
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    private String strikeMessage(int strike) {
        return String.format("%s스트라이크 ", strike);
    }

    private String ballMessage(int ball) {
        return String.format("%s볼", ball);
    }

    public void viewStartMessage() {
        System.out.print(GAME_START_MESSAGE);
    }

    public void viewGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void viewGameSystemMessage() {
        System.out.println(GAME_SYSTEM_MESSAGE);
    }
}
