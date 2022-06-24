package racingcar.gameStrategy;

import java.util.Objects;

// TODO: 클래스명
public final class Energy {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private final int value;

    private Energy(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static Energy valueOf(int value) {
        return new Energy(value);
    }

    public boolean isMoreThan(Energy other) {
        return this.value >= other.value;
    }

    public boolean isLessThan(Energy other) {
        return this.value < other.value;
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
