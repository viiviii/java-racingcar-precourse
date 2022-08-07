package racingcar.gameStrategy;

import java.util.Objects;

final class Position {
    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position valueOf(int value) {
        return new Position(value);
    }

    public static Position init() {
        return Position.valueOf(0);
    }

    public Position increase() {
        final int increased = value + 1;
        return Position.valueOf(increased);
    }

    public int value() {
        return value;
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
}
