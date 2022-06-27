package racingcar.gamePlay;

import java.util.ArrayList;
import java.util.List;

// TODO: 클래스명
public final class AttemptCount {
    private static final int MINIMUM_ATTEMPT_COUNT = 0;
    private final int count;

    public AttemptCount(int count) {
        validateMin(count);
        this.count = count;
    }

    private void validateMin(int count) {
        if (count < MINIMUM_ATTEMPT_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public Result move(Cars cars) {
        final ResultImpl result = new ResultImpl();
        for (int i = MINIMUM_ATTEMPT_COUNT; i < count; i++) {
            final Record record = cars.move();
            result.add(record);
        }
        return result;
    }

    private static final class ResultImpl implements Result {
        private final List<Record> records = new ArrayList<>();

        private void add(Record record) {
            records.add(record);
        }

        @Override
        public int attemptCount() {
            return records.size();
        }

        @Override
        public Record firstRecord() {
            return records.get(MINIMUM_ATTEMPT_COUNT);
        }

        @Override
        public Record lastRecord() {
            return records.get(records.size() - 1);
        }

        @Override
        public Iterable<Record> allRecords() {
            return new ArrayList<>(records);
        }
    }
}
