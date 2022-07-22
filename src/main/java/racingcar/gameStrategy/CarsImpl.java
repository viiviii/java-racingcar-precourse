package racingcar.gameStrategy;

import racingcar.gamePlay.CarPosition;
import racingcar.gamePlay.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CarsImpl implements Cars {
    private final List<Car> cars;

    // TODO
    public CarsImpl(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(Car... cars) {
        return new CarsImpl(Arrays.asList(cars));
    }

    @Override
    public List<CarPosition> move() {
        final List<CarPosition> carPositions = new ArrayList<>();
        for (Car car : cars) {
            final int movedPosition = car.move();
            final CarPosition carPosition = new CarPosition(car.name(), movedPosition);
            carPositions.add(carPosition);
        }
        return carPositions;
    }
}
