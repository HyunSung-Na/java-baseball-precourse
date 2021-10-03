package baseball.game;

import java.util.List;

public interface Computer {
    int MIN_NUM = 1;
    int MAX_NUM = 9;
    int NUMBER_LENGTH = 3;

    List<Character> getNumber();
}
