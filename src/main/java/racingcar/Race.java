package racingcar;

import java.util.ArrayList;
import java.util.List;

public final class Race {
    private final Car car;
    private final MyRandom myRandom;

    public Race(Car car, MyRandom myRandom) {
        this.car = car;
        this.myRandom = myRandom;
    }

    public List<Boolean> movesBy(int moveTimes) {
        final List<Boolean> movements = new ArrayList<>();
        for (int move = 0; move < moveTimes; move++) {
            final int condition = myRandom.pickNumberInRage(0, 9);
            final boolean moved = car.move(condition);
            movements.add(moved);
        }
        return movements;
    }
}
