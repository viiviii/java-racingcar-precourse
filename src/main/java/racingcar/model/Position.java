package racingcar.model;

public final class Position {
    private static final int DEFAULT = 0;
    
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public static Position fromZero() {
        return Position.from(DEFAULT);
    }

    public int get() {
        return position;
    }

    public void increase() {
        position += 1;
    }
}
