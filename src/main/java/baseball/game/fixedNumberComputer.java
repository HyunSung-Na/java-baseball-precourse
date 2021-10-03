package baseball.game;

import java.util.List;

public class fixedNumberComputer implements Computer{
    private final List<Character> number;

    public fixedNumberComputer(List<Character> number) {
        this.number = number;
    }

    @Override
    public List<Character> getNumber() {
        return number;
    }
}
