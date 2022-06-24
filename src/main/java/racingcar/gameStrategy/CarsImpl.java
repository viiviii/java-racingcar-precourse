package racingcar.gameStrategy;

import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Record;

import java.util.*;

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
    public Record move() {
        final PositionRecord record = new PositionRecord();
        for (Car car : cars) {
            final int movedPosition = car.move();
            record.put(car.name(), movedPosition);
        }
        return record;
    }

    private static final class PositionRecord implements Record {
        private final Map<String, Integer> record = new HashMap<>();

        private void put(String carName, int position) {
            record.put(carName, position);
        }

        @Override
        public Set<String> carNames() {
            return record.keySet();
        }

        @Override
        public int positionBy(String carName) {
            return record.get(carName);
        }
    }
}
