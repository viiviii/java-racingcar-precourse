package racingcar;

import java.util.Objects;

public final class Position {
    public static final Position zero = new Position(0);
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position add(Position other) {
        final int added = this.position + other.position;
        return new Position(added);
    }

    public int toInt() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position other = (Position) o;
        return this.position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
