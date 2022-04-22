package racingcar.model;

public final class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int get() {
        return position;
    }

    public void increase() {
        position += 1;
    }
}
