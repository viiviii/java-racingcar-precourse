package racingcar.model.car;

public final class Position {
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

    // TODO: 생성자 없앨 수 있나? -> view에서 원시 값 사용하면 가능함
    public static Position from(int position) {
        return new Position(position);
    }

    public static Position fromZero() {
        return Position.from(DEFAULT);
    }

    public int get() {
        return value;
    }

    void increase() {
        value += 1;
    }
}
