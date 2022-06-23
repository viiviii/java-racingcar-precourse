package racingcar.gameStrategy;

import racingcar.gamePlay.Car;

public final class CarImpl implements Car {
    private final String name;
    private int position = 0;

    public CarImpl(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int position() {
        return position;
    }

    @Override
    public int move(int condition) {
        increasePosition(condition);
        return position();
    }

    // TODO
    private void increasePosition(int condition) {
        position += condition > 3 ? 1 : 0;
    }
}
