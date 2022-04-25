package racingcar.rule;

import camp.nextstep.edu.missionutils.Randoms;

// TODO
public class Energy {
    private static final int MIN = 0;
    private static final int MAX = 9;

    private final int value;

    private Energy(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int energy) {
        if (energy < MIN || energy > MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static Energy fromInteger(int energy) {
        return new Energy(energy);
    }

    public static Energy atRandom() {
        final int random = Randoms.pickNumberInRange(MIN, MAX);
        return new Energy(random);
    }

    public int get() {
        return value;
    }
}
