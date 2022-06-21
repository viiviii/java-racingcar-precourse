package racingcar;

import java.util.ArrayList;
import java.util.List;

public final class Race {
    private final Car car;
    private final MyRandom myRandom;

    public Race(Car car, MyRandom myRandom) {
        this.car = car;
        this.myRandom = myRandom;
    }

    public RaceResult movesBy(int moveTimes) {
        final RaceResultImpl record = new RaceResultImpl();
        for (int index = 0; index < moveTimes; index++) {
            final int condition = myRandom.pickNumberInRage(0, 9);
            final int movedPosition = car.move(condition);
            record.put(movedPosition);
        }
        return record; // TODO
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
