package racingcar.gameStrategy;

import racingcar.gamePlay.CarPosition;
import racingcar.gamePlay.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class CarsImpl implements Cars {
    private final List<Car> cars;

    // TODO
    private CarsImpl(List<Car> cars) {
        this.cars = cars;
    }

    static Cars of(Car... cars) {
        return new CarsImpl(Arrays.asList(cars));
    }

    @Override
    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    @Override
    public List<CarPosition> positions() {
        final List<CarPosition> carPositions = new ArrayList<>();
        for (Car car : cars) {
            carPositions.add(toCarPosition(car));
        }
        return carPositions;
    }

    private CarPosition toCarPosition(Car car) {
        return new CarPosition(car.name(), car.position());
    }
}
