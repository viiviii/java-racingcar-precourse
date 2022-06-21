package racingcar;

import java.util.*;

public final class Race {
    private final List<Car> cars;
    private final MyRandom myRandom;

    public Race(List<Car> cars, MyRandom myRandom) {
        this.cars = cars;
        this.myRandom = myRandom;
    }

    public RaceResult movesBy(int moveTimes) {
        final RaceResultImpl raceResult = new RaceResultImpl();
        for (int index = 0; index < moveTimes; index++) {
            final MoveRecord record = new MoveRecord();
            for (Car car : cars) {
                final int condition = myRandom.pickNumberInRage(0, 9);
                final int movedPosition = car.move(condition);
                record.put(car.name(), movedPosition);
            }
            raceResult.add(record);
        }
        return raceResult; // TODO
    }

    // TODO: 얘도 주입받아야 될 거 같애 자동차 이름까지 생기면 변경하기
    private static final class RaceResultImpl implements RaceResult {
        private final List<Record> records = new ArrayList<>();

        private void add(Record record) {
            records.add(record);
        }

        @Override
        public int moveTimes() {
            return records.size();
        }

        @Override
        public List<Record> toList() {
            return new ArrayList<>(records); // TODO
        }
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
