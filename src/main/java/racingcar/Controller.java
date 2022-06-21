package racingcar;

import java.util.List;

public final class Controller {
    private final View view;
    private final MyRandom myRandom;

    public Controller(View view, MyRandom myRandom) {
        this.view = view;
        this.myRandom = myRandom;
    }

    public void start() {
        final int moveTimes = view.inputMoveTimes();
        // TODO: new Car, new Race
        final Car car = new CarImpl();
        final Race race = new Race(car, myRandom);
        final List<Integer> movements = race.movesBy(moveTimes);
        view.moveResult(movements);
    }
}
