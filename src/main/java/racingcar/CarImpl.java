package racingcar;

public final class CarImpl implements Car {

    @Override
    public boolean move(int number) {
        return number > 3;
    }
}
