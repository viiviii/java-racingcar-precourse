package racingcar.gamePlay;

import racingcar.MyRandom;
import racingcar.gameStrategy.AttemptCountImpl;
import racingcar.gameStrategy.CarImpl;
import racingcar.gameStrategy.RandomMoveCars;

import java.util.ArrayList;
import java.util.List;

public final class Controller {
    private final View view;
    private final MyRandom myRandom;

    public Controller(View view, MyRandom myRandom) {
        this.view = view;
        this.myRandom = myRandom;
    }

    public void start() {
        // TODO: new Car, new Cars, new AttemptCount
        final Cars cars = inputCars();
        final AttemptCount attemptCount = inputAttemptCount();
        final RaceResult raceResult = attemptCount.move(cars);
        view.raceResult(raceResult);
    }

    private Cars inputCars() {
        final List<String> carNames = view.inputCarNames();
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            final Car car = new CarImpl(carName);
            cars.add(car);
        }
        return new RandomMoveCars(cars, myRandom);
    }

    private AttemptCount inputAttemptCount() {
        final int attemptCount = view.inputAttemptCount();
        return new AttemptCountImpl(attemptCount);
    }
}
