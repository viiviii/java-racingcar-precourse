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
        final List<String> carNames = view.inputCarNames();
        final int moveTimes = view.inputMoveTimes();
        // TODO: new Car, new Race
        final List<Car> cars = createCars(carNames);
        final Race race = new Race(cars, myRandom);
        final RaceResult movements = race.movesBy(moveTimes);
        view.raceResult(movements);
    }

    private List<Car> createCars(List<String> carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            final Car car = new CarImpl(carName);
            cars.add(car);
        }
        return cars;
    }
}
