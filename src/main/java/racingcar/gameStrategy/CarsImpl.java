package racingcar.gameStrategy;

import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Movement;
import racingcar.gamePlay.Records;

import java.util.Arrays;
import java.util.List;

public final class CarsImpl implements Cars {
    private final RememberingRecords records = new RememberingRecords();
    private final List<Car> cars;

    // TODO
    private CarsImpl(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(Car... cars) {
        return new CarsImpl(Arrays.asList(cars));
    }

    @Override
    public void move() {
        for (Car car : cars) {
            final Movement movement = car.move();
            records.save(car.name(), movement);
        }
    }

    @Override
    public Records records() {
        return records;
    }
}
