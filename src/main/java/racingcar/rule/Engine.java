package racingcar.rule;

public class Engine {
    public static final Energy FORWARD_ENERGY = Energy.from(4);

    public Move powerBy(Energy energy) {
        if (energy.isLessThan(FORWARD_ENERGY)) {
            return Move.STOP;
        }
        return Move.FORWARD;
    }
}
