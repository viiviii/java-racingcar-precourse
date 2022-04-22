package racingcar.model;

public final class Energy {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private final int value;

    public Energy(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int energy) {
        if (energy < MIN || energy > MAX) {
            throw new IllegalArgumentException();
        }
    }

    public int get() {
        return value;
    }
}
