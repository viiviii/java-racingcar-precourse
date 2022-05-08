package racingcar.rule;

import java.util.Objects;

public final class Energy {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private final int value;

    private Energy(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int energy) {
        if (energy < MIN || energy > MAX) {
            final String message = String.format("범위가 유효하지 않음. 유효 범위=(%d~%d)", MIN, MAX);
            throw new IllegalArgumentException(message);
        }
    }

    public static Energy from(int energy) {
        return new Energy(energy);
    }

    public int get() {
        return value;
    }

    public boolean isLessThan(Energy other) {
        return this.value < other.value;
    }

    public boolean isGraterThan(Energy other) {
        return this.value > other.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Energy)) return false;
        Energy energy = (Energy) o;
        return value == energy.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
