package racingcar.race;

import racingcar.rule.MoveCount;
import racingcar.rule.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RacingCars {
    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
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

    public static RacingCars from(List<Car> cars) {
        return new RacingCars(cars);
    }

    public static RacingCars from(Car... cars) {
        return RacingCars.from(Arrays.asList(cars));
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
            car.move();
            result.add(CarDto.from(car));
        }
        return result;
    }

    public WinnersDto getWinners() {
        final Winners winners = new Winners();
        final List<Name> winnerNames = winners.determineFrom(cars);
        return WinnersDto.from(winnerNames);
    }
}
