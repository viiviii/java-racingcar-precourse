package racingcar;

import java.util.ArrayList;
import java.util.List;

public final class Controller {
    private final View view;
    private final Car car;
    private final MyRandom myRandom;

    public Controller(View view, Car car, MyRandom myRandom) {
        this.view = view;
        this.car = car;
        this.myRandom = myRandom;
    }

    public void start() {
        final int moveTimes = view.inputMoveTimes();
        final List<Boolean> movements = carMovesBy(moveTimes);
        view.moveResult(movements);
    }

    private List<Boolean> carMovesBy(int moveTimes) {
        final List<Boolean> movements = new ArrayList<>();
        for (int move = 0; move < moveTimes; move++) {
            final int condition = myRandom.pickNumberInRage(0, 9);
            final boolean moved = car.move(condition);
            movements.add(moved);
        }
        return movements;
    }
}
