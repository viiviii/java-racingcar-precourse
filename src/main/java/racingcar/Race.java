package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Race {
    private final List<Car> cars;
    private final MyRandom myRandom;

    public Race(List<Car> cars, MyRandom myRandom) {
        this.cars = cars;
        this.myRandom = myRandom;
    }

    public Record moveAllCars() {
        final MoveRecord record = new MoveRecord();
        for (Car car : cars) {
            final int condition = myRandom.pickNumberInRage(0, 9);
            final int movedPosition = car.move(condition);
            record.put(car.name(), movedPosition);
        }
        return record;
    }

    private static final class MoveRecord implements Record {
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
