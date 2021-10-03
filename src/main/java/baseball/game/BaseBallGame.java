package baseball.game;

import java.util.List;

public class BaseBallGame {

    private final int GAME_END_CONDITION_NUMBER = 3;

    private final Computer computer;

    private int strike = 0;
    private int ball = 0;

    public BaseBallGame(Computer computer) {
        this.computer = computer;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public Boolean changeUp(int userInput) {
        return judgmentGame(userInput);
    }

    private Boolean judgmentGame(int userInput) {
        countStrikeAndBall(userInput);
        if (strike == GAME_END_CONDITION_NUMBER) {
            return true;}

        initStrikeAndBallCount();

        return false;
    }

    public void countStrikeAndBall(int userInput) {
        List<Character> computerNumber = computer.getNumber();
        char[] userNumbers = String.valueOf(userInput).toCharArray();

        for (int index = 0; index < userNumbers.length; index++) {
            if (computerNumber.contains(userNumbers[index])) {
                checkStrikeAndBall(userNumbers[index], computerNumber.get(index));
            }
        }
    }

    private void initStrikeAndBallCount() {
        strike = 0;
        ball = 0;
    }

    private void checkStrikeAndBall(char userNumber, char computerNumber) {
        if (userNumber == computerNumber) {
            strike++;
            return;
        }

        ball++;
    }
}
