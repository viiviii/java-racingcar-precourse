package racingcar.model;

public final class Engine {

    public Move powerBy(Energy energy) {
        final int MIN_FORWARD_ENERGY = 4;
        if (energy.get() >= MIN_FORWARD_ENERGY) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
