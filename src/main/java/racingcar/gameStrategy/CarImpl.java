package racingcar.gameStrategy;

import racingcar.MyRandom;
import racingcar.gamePlay.Car;

public final class CarImpl implements Car {
    private final MyRandom myRandom;
    private final String name;
    private int position = 0;

    public CarImpl(MyRandom myRandom, String name) {
        this.myRandom = myRandom;
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
    public int move() {
        final int condition = myRandom.pickNumberInRage(0, 9); // TODO
        increasePosition(condition);
        return position();
    }

    // TODO
    private void increasePosition(int condition) {
        position += condition > 3 ? 1 : 0;
    }
}
