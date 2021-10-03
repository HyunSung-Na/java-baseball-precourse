package baseball.game;

import nextstep.utils.Console;

import static baseball.game.GameMessage.*;

public class UserInputManager {
    private final static int MAX_NUMBER = 999;
    private final static int MIN_NUMBER = 100;
    public final static int GAME_RESTART_NUMBER = 1;
    public final static int GAME_END_NUMBER = 2;

    public int userInput() {
         int userInput = 0;
         try {
             userInput = Integer.parseInt(Console.readLine());
         } catch (NumberFormatException e) {
             System.out.println(WRONG_USER_INPUT_ERROR_MESSAGE);
             userInput = userInput();
         }
         return userInput;
    }

    public int isReStartGameSelectUserInput() {
        int userInput = userInput();

        while (userInput != GAME_RESTART_NUMBER && userInput != GAME_END_NUMBER) {
            System.out.println(WRONG_USER_INPUT_ERROR_MESSAGE);
            System.out.println(GAME_SYSTEM_MESSAGE);
            userInput = userInput();
        }

        return userInput;
    }

    public int playerInputData() {
        int userInput = userInput();

        while (!validateUserInput(userInput)) {
            userInput = userInput();
        }

        return userInput;
    }

    private boolean validateUserInput(int userInput) {
        try {
            validNumberRange(userInput);
            duplicateNumberCheck(userInput);
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println(WRONG_USER_INPUT_ERROR_MESSAGE);
            System.out.print(GAME_START_MESSAGE);
            return false;
        }
    }

    private void validNumberRange(int userInput) {
        if (userInput < MIN_NUMBER || userInput > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumberCheck(int userInput) {
        char[] duplicateNumberCheck = String.valueOf(userInput).toCharArray();

        if (isDuplicateNumber(duplicateNumberCheck)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateNumber(char[] duplicateNumberCheck) {
        if (duplicateNumberCheck[0] == duplicateNumberCheck[1]) { return true; }
        if (duplicateNumberCheck[1] == duplicateNumberCheck[2]) { return true; }
        return duplicateNumberCheck[2] == duplicateNumberCheck[0];
    }
}
