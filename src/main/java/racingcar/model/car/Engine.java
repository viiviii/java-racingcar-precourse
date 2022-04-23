package racingcar.model.car;

import racingcar.model.Energy;

final class Engine {
    static final int MIN_FORWARD_ENERGY = 4;

    Move powerBy(Energy energy) {
        if (energy.get() >= MIN_FORWARD_ENERGY) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
