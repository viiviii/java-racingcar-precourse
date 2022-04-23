package racingcar.model.car;

final class Position {
    private static final int DEFAULT = 0;

    private int value;

    private Position(int position) {
        validateRange(position);
        this.value = position;
    }

    private void validateRange(int position) {
        if (position < DEFAULT) {
            throw new IllegalArgumentException();
        }
    }

    static Position init() {
        return new Position(DEFAULT);
    }

    static Position copyOf(Position position) {
        return new Position(position.get());
    }

    void increase() {
        value += 1;
    }

    int get() {
        return value;
    }
}
