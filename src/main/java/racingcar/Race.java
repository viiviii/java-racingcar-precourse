package racingcar;

import java.util.ArrayList;
import java.util.List;

public final class Race {
    private final List<Car> cars;
    private final MyRandom myRandom;

    public Race(List<Car> cars, MyRandom myRandom) {
        this.cars = cars;
        this.myRandom = myRandom;
    }

    public RaceResult movesBy(int moveTimes) {
        final RaceResult raceResult = new RaceResultImpl();
        for (int index = 0; index < moveTimes; index++) {
            final List<Integer> positions = new ArrayList<>();
            for (Car car : cars) {
                final int condition = myRandom.pickNumberInRage(0, 9);
                final int movedPosition = car.move(condition);
                positions.add(movedPosition);
            }
        }
        return raceResult; // TODO
    }

    // TODO: 얘도 주입받아야 될 거 같애 자동차 이름까지 생기면 변경하기
    private static final class RaceResultImpl implements RaceResult {
        private final List<Integer> positions = new ArrayList<>();

        private void put(int position) {
            positions.add(position);
        }

        @Override
        public int moveTimes() {
            return positions.size();
        }

        @Override
        public List<Integer> toList() {
            return new ArrayList<>(positions);
        }
    }
}
