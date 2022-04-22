package racingcar.model;

public final class Engine {

    public Move powerBy(int energy) {
        final int MIN_FORWARD_ENERGY = 4;
        if (energy >= MIN_FORWARD_ENERGY) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
