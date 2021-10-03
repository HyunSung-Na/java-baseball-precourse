package baseball.game;

public class GameResultView {

    private final String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String NOT_MATCH_STRIKE_BALL_MESSAGE = "낫싱";

    private final int gameMessageStartIndex = 0;

    private final StringBuilder gameMessage = new StringBuilder();

    void viewGameMessage(int strike, int ball) {
        checkBallMessage(ball);
        checkStrikeMessage(strike);
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

    public void gameSuccessMessage(int strike) {
        System.out.println(strikeMessage(strike));
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    private String strikeMessage(int strike) {
        return String.format("%s스트라이크", strike);
    }

    private String ballMessage(int ball) {
        return String.format("%s볼 ", ball);
    }
}
