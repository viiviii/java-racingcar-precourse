package racingcar;

public final class CarImpl implements Car {

    private int position = 0;

    public CarImpl() {
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
