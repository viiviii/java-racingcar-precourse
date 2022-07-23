package racingcar.gameStrategy;

public final class Car {
    private final EnergyFactory energyFactory;
    private final String name;
    private int position = 0;

    public Car(EnergyFactory energyFactory, String carName) {
        this.energyFactory = energyFactory;
        this.name = carName;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public int move() {
        final MovementNumber movementNumber = energyFactory.random();
        if (isForward(movementNumber)) {
            increasePosition();
        }
        return position();
    }

    private boolean isForward(MovementNumber movementNumber) {
        final MovementNumber MINIMUM_FORWARD = MovementNumber.valueOf(4);// TODO
        return movementNumber.isMoreThan(MINIMUM_FORWARD);
    }

    private void increasePosition() {
        position += 1;
    }
}
