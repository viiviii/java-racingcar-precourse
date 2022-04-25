package racingcar.rule;

public class Engine {
    public static final int MIN_FORWARD_ENERGY = 4; // TODO: 에너지 써야지

    public Move powerBy(Energy energy) {
        if (energy.get() >= MIN_FORWARD_ENERGY) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
