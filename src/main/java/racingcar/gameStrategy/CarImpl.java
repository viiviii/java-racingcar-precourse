package racingcar.gameStrategy;

public final class CarImpl {
    private final String name;
    private int position = 0;

    public CarImpl(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public int move(int condition) {
        increasePosition(condition);
        return position();
    }

    private void increasePosition(int condition) {
        position += condition > 3 ? 1 : 0;
    }
}
