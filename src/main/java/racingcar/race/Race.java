package racingcar.race;

import racingcar.rule.Energy;
import racingcar.rule.MoveCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Race {
    private final List<Car> cars;

    private Race(List<Car> cars) {
        this.cars = cars;
    }

    public static Race from(String... names) {
        return new Race(mapCars(names));
    }

    public static Race from(Car... cars) {
        return new Race(Arrays.asList(cars));
    }

    static List<Car> mapCars(String... names) {
        final List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.inStartingPositionWith(name));
        }
        return cars;
    }

    public List<List<CarResult>> startWith(MoveCount moveCount) {
        final List<List<CarResult>> result = new ArrayList<>();
        for (int i = 0; i < moveCount.get(); i++) {
            final List<CarResult> moveCar = move();
            result.add(moveCar);
        }
        return result;
    }

    private List<CarResult> move() {
        final List<CarResult> result = new ArrayList<>();
        for (Car car : cars) {
            final Energy energy = Energy.atRandom();
            car.moveBy(energy);
            result.add(carResult(car));
        }
        return result;
    }

    private CarResult carResult(Car car) {
        return new CarResult(car.name(), car.position());
    }

    public List<String> getWinner() {
        final int raceMaxPosition = maxPosition();
        final List<String> names = new ArrayList<>();
        for (Car car : cars) {
            // TODO
            if (car.inPosition(raceMaxPosition)) {
                names.add(car.name());
            }
        }
        return names;
    }

    private int maxPosition() {
        return Collections
                .max(cars, Car::compareToPosition)
                .position();
    }
}
