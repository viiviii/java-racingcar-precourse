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
        final int moveCount = view.inputMoveCount();
        final List<Boolean> movements = new ArrayList<>();
        for (int move = 0; move < moveCount; move++) {
            int condition = myRandom.pickNumberInRage(0, 9);
            boolean moved = car.move(condition);
            movements.add(moved);
        }
        view.moveResult(movements);
    }
}
