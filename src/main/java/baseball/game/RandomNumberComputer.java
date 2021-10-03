package baseball.game;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberComputer implements Computer{

    private final List<Character> number;

    public RandomNumberComputer() {
        number = createComputerNumber();
    }

    public List<Character> getNumber() {
        return number;
    }

    private List<Character> createComputerNumber() {
        boolean[] validDuplicateNumber = new boolean[MAX_NUM + 1];
        List<Character> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!validDuplicateNumber[randomNumber]) {
                validDuplicateNumber[randomNumber] = true;
                numbers.add(Character.forDigit(randomNumber, 10));
            }
        }
        return numbers;
    }
}
