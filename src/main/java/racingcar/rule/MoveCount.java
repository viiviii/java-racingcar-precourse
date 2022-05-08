package racingcar.rule;

import java.util.Objects;

public final class MoveCount {
    private final int value;

    public MoveCount(int value) {
        validateMin(value);
        validateMax(value);
        this.value = value;
    }

    private void validateMin(int moveCount) {
        final int MIN_MOVE_COUNT = 1;
        if (moveCount < MIN_MOVE_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 한다.");
        }
    }

    private void validateMax(int moveCount) {
        final int MAX_MOVE_COUNT = 100;
        if (moveCount > MAX_MOVE_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 100 이하여야 한다.");
        }
    }

    // TODO
    public static MoveCount fromString(String input) {
        final int count = Integer.parseInt(input);
        return new MoveCount(count);
    }

    public int get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoveCount)) return false;
        MoveCount moveCount = (MoveCount) o;
        return value == moveCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
