package racingcar.gamePlay;

import java.util.ArrayList;
import java.util.List;

// TODO: 클래스명
public final class AttemptCount {
    private final int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public RaceResult move(Cars cars) {
        final ResultImpl result = new ResultImpl();
        for (int i = 0; i < count; i++) {
            final Record record = cars.move();
            result.add(record);
        }
        return result;
    }

    private static final class ResultImpl implements RaceResult {
        private final List<Record> records = new ArrayList<>();

        private void add(Record record) {
            records.add(record);
        }

        @Override
        public int attemptCount() {
            return records.size();
        }

        @Override
        public Record recordOf(int attemptIndex) {
            return records.get(attemptIndex);
        }
    }
}
