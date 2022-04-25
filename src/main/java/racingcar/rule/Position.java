package racingcar.rule;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int DEFAULT = 0;

    private int value;

    public Position(int position) {
        validateRange(position);
        this.value = position;
    }

    private void validateRange(int position) {
        if (position < DEFAULT) {
            throw new IllegalArgumentException();
        }
    }

    public static Position init() {
        return new Position(DEFAULT);
    }

    public void increase() {
        value += 1;
    }

    public int get() {
        return value;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Position{" + "value=" + value + '}';
    }
}
