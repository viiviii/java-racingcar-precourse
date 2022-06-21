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

    public List<Position> movesBy(int moveTimes) {
        final Record record = new Record();
        for (int index = 0; index < moveTimes; index++) {
            final int condition = myRandom.pickNumberInRage(0, 9);
            final boolean moved = car.move(condition);
            final Position position = new Position(moved ? 1 : 0); // TODO: 어디서?
            record.put(position);
        }
        return record.toList(); // TODO
    }

    // TODO: 얘도 주입받아야 될 거 같애 자동차 이름까지 생기면 변경하기
    private static final class Record {
        private final List<Position> positions = new ArrayList<>();

        private void put(Position position) {
            final Position previous = last();
            positions.add(position.add(previous));
        }

        private Position last() {
            final int size = positions.size();
            return size == 0 ? Position.zero : positions.get(size - 1);
        }

        private List<Position> toList() {
            return new ArrayList<>(positions);
        }
    }
}
