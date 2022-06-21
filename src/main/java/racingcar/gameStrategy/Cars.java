package racingcar.gameStrategy;

import racingcar.MyRandom;
import racingcar.gamePlay.Car;
import racingcar.gamePlay.Record;

import java.util.*;

public final class Cars {
    private final List<Car> cars;
    private final MyRandom myRandom; // TODO

    // TODO
    public Cars(List<Car> cars, MyRandom myRandom) {
        this.cars = cars;
        this.myRandom = myRandom;
    }

    public static Cars of(MyRandom myRandom, Car... cars) {
        return new Cars(Arrays.asList(cars), myRandom);
    }

    public Record move() {
        final PositionRecord record = new PositionRecord();
        for (Car car : cars) {
            final int condition = myRandom.pickNumberInRage(0, 9);
            final int movedPosition = car.move(condition);
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
