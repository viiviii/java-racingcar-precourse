package racingcar;

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
        // TODO: new Car, new Race, new AttemptCount
        final List<Car> cars = inputCars();
        final Race race = new Race(cars, myRandom);
        final AttemptCount attemptCount = inputAttemptCount();
        final RaceResult raceResult = attemptCount.move(race);
        view.raceResult(raceResult);
    }

    private List<Car> inputCars() {
        final List<String> carNames = view.inputCarNames();
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            final Car car = new CarImpl(carName);
            cars.add(car);
        }
        return cars;
    }

    private AttemptCount inputAttemptCount() {
        final int attemptCount = view.inputAttemptCount();
        return new AttemptCount(attemptCount);
    }
}
