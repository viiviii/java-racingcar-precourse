package racingcar.race;

import racingcar.rule.Energy;
import racingcar.rule.MoveCount;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Race {
    private final List<Car> cars;

    private Race(List<Car> cars) {
        validateMinSize(cars);
        validateMaxSize(cars);
        this.cars = cars;
    }

    private void validateMinSize(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차는 1대 이상이어야 한다.");
        }
    }

    private void validateMaxSize(List<Car> cars) {
        final int MAX_SIZE = 10;
        if (cars.size() > MAX_SIZE) {
            throw new IllegalArgumentException("경주할 자동차는 10대 이하여야 한다.");
        }
    }

    public static Race from(String... names) {
        return new Race(mapCars(names));
    }

    public static Race from(Car... cars) {
        return new Race(Arrays.asList(cars));
    }

    static List<Car> mapCars(String... names) {
        final Position position = Position.start();
        final List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.of(name, position));
        }
        return cars;
    }

    public List<List<CarDto>> startWith(MoveCount moveCount) {
        final List<List<CarDto>> result = new ArrayList<>();
        for (int i = 0; i < moveCount.get(); i++) {
            final List<CarDto> moveCar = move();
            result.add(moveCar);
        }
        return result;
    }

    private List<CarDto> move() {
        final List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            final Energy energy = Energy.atRandom();
            car.moveBy(energy);
            result.add(CarDto.from(car));
        }
        return result;
    }

    public Winners getWinners() {
        final Position raceMaxPosition = maxPosition();
        final Winners winners = new Winners();
        for (Car car : cars) {
            addNameWhenSamePositionTo(winners, raceMaxPosition, car);
        }
        return winners;
    }

    private void addNameWhenSamePositionTo(Winners winners, Position raceMaxPosition, Car car) {
        if (car.inPosition(raceMaxPosition)) {
            winners.add(car.name());
        }
    }

    private Position maxPosition() {
        return Collections
                .max(cars, Car::comparePositionTo)
                .position();
    }
}
