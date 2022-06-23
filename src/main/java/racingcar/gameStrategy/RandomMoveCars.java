package racingcar.gameStrategy;

import racingcar.MyRandom;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Record;

import java.util.*;

public final class RandomMoveCars implements Cars {
    private final List<CarImpl> cars;
    private final MyRandom myRandom; // TODO

    // TODO
    public RandomMoveCars(List<CarImpl> cars, MyRandom myRandom) {
        this.cars = cars;
        this.myRandom = myRandom;
    }

    public static Cars of(MyRandom myRandom, CarImpl... cars) {
        return new RandomMoveCars(Arrays.asList(cars), myRandom);
    }

    @Override
    public Record move() {
        final PositionRecord record = new PositionRecord();
        for (CarImpl car : cars) {
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
