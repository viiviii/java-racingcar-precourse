package racingcar.gameStrategy;

import java.util.Objects;

// TODO: 클래스명
public final class MovementNumber {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private final int value;

    private MovementNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static MovementNumber valueOf(int value) {
        return new MovementNumber(value);
    }

    public boolean isMoreThan(MovementNumber other) {
        return this.value >= other.value;
    }

    public boolean isLessThan(MovementNumber other) {
        return this.value < other.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovementNumber)) return false;
        MovementNumber movementNumber = (MovementNumber) o;
        return value == movementNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
